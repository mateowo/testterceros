/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.service;

import co.edu.javeriana.universityapp.entity.Clasificacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mariajosemendoza
 */
@Stateless
@Path("clasificacion")
public class ClasificacionFacadeREST extends AbstractFacade<Clasificacion> {

    @PersistenceContext(unitName = "co.edu.javeriana_UniversityApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ClasificacionFacadeREST() {
        super(Clasificacion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Clasificacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Clasificacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Clasificacion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clasificacion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clasificacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
        @GET
    @Path("clasi1")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clasificacion> clasi1() {
        List<Clasificacion> lista =  super.findAll();
        List<Clasificacion> lista2 = new ArrayList<Clasificacion>();
        for(Clasificacion l : lista){
            if(l.getNumeroclasificacion() == 1){
                lista2.add(l);
            }
        }
        return lista2;
    }
    
    @GET
    @Path("clasi2")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clasificacion> clasi2() {
        List<Clasificacion> lista =  super.findAll();
        List<Clasificacion> lista2 = new ArrayList<Clasificacion>();
        for(Clasificacion l : lista){
            if(l.getNumeroclasificacion() == 2){
                lista2.add(l);
            }
        }
        return lista2;
    }

    @GET
    @Path("clasi3")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clasificacion> clasi3() {
        List<Clasificacion> lista =  super.findAll();
        List<Clasificacion> lista2 = new ArrayList<Clasificacion>();
        for(Clasificacion l : lista){
            if(l.getNumeroclasificacion() == 3){
                lista2.add(l);
            }
        }
        return lista2;
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
