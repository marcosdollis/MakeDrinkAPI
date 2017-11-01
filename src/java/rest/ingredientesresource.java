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
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import model.Ingredientes;
import org.hibernate.Session;
import util.HibernateUtil;

@Path("ingredientes")
public class ingredientesresource {

    @Context
    private UriInfo context;

    public ingredientesresource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Ingredientes ingrediente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(ingrediente);
        session.getTransaction().commit();
        session.close();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
public List<Ingredientes> lista_user(){
   Session session = HibernateUtil.getSessionFactory().openSession();
   List<Ingredientes> lista = session.createQuery("From Ingredientes").list();
   return lista;
    
}
}
