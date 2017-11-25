/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Producao;
import model.Usuario;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * REST Web Service
 *
 * @author MARCOS FELIPE
 */
// 
@Path("usuario")
public class usuarioresoure {

    @Context
    private UriInfo context;

    public usuarioresoure() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Usuario user) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> lista_user() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> lista = session.createQuery("From Usuario").list();
        return lista;

    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public Usuario login(Usuario u) {
        Usuario logado = new Usuario();
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Usuario as u where u.email = :a and u.senha = :b";
        Query q = session.createQuery(query);
        q.setParameter("a", u.getEmail());
        q.setParameter("b", u.getSenha());

        logado = (Usuario) q.uniqueResult();

        if (logado != null) {
            logado.setAutenticado(true);

        } else {
            logado = new Usuario();

        }

        return logado;

    }

    @DELETE
    @Path("/{id}")
    public void delete(final @PathParam("id") String id, Usuario usuario) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(id);
        session.getTransaction().commit();
        session.close();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
    }

}
