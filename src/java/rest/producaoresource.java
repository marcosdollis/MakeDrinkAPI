/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Ingredientes;
import model.Producao;
import model.Produto;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * REST Web Service
 *
 * @author MARCOS FELIPE
 */
@Path("producao")
public class producaoresource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of producaoresource
     */
    public producaoresource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Producao producao) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.save(producao);
        session.getTransaction().commit();
        session.close();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producao> lista_producao() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Producao> lista = session.createQuery("From Producao").list();
        return lista;

    }

    @DELETE
    @Path("/{id}")
    public void delete(final @PathParam("id") String id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(id);
        session.getTransaction().commit();
        session.close();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Producao producao) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.merge(producao);
        session.getTransaction().commit();
        session.close();
    }

}
