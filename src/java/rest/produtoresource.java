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
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Produto;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 * REST Web Service
 *
 * @author MARCOS FELIPE
 */
@Path("produto")
public class produtoresource {

    @Context
    private UriInfo context;

    public produtoresource() {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Produto produto) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();
        session.save(produto);
        session.getTransaction().commit();
        session.close();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
public List<Produto> lista_user(){
   Session session = HibernateUtil.getSessionFactory().openSession();
   List<Produto> lista = session.createQuery("From Produto").list();
   return lista;
    
}
    
    
    

}
