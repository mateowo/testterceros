/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.service;

import co.edu.javeriana.universityapp.entity.Contacto;
import co.edu.javeriana.universityapp.entity.Tercero;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("contacto")
public class ContactoFacadeREST extends AbstractFacade<Contacto> {

    
    @EJB
    private TerceroFacadeREST terceroFacadeREST;
    
    @PersistenceContext(unitName = "co.edu.javeriana_UniversityApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ContactoFacadeREST() {
        super(Contacto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Contacto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Contacto entity) {
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
    public Contacto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Contacto> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Contacto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getId() throws InterruptedException {

        Thread.sleep(500);
        List<Contacto> lista = super.findAll();
        int max = 0;
        for (Contacto t : lista) {
            if (t.getIdcontacto() > max) {
                max = t.getIdcontacto();
            }
        }
        return max + 1;

    }
    
    
    @GET
    @Path("asociarTerceroContacto/{idTercero}/{idContacto}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asociarTerceroContacto(@PathParam("idTercero") Integer idTercero, @PathParam("idContacto") Integer idContacto) throws InterruptedException {

        Thread.sleep(500);
        Contacto c = find(idContacto);
        Tercero t = terceroFacadeREST.find(idTercero);
        System.out.println("CONTACTOOOOOOOOOOOOOOOOOOOOOOOOO: "+c.getNombrecontacto());
        System.out.println("TERCEROOOOOOOOOOOOOOOOOOOOOOOOOO: "+t.getPrimernombre());
        c.setIdtercero(t);
        em.persist(c); 
    }
    
    @GET
    @Path("getContactosByTerceros/{idTercero}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Contacto> getContactosByTerceros(@PathParam("idTercero") Integer idTercero) throws InterruptedException {

        Thread.sleep(900);
        //Query query = em.createNamedQuery("Contacto.findByTercero");
        //query.setParameter("idtercero", idTercero);
        List<Contacto> contactos = findAll();
        List<Contacto> contEnviar= new ArrayList<>();
        System.out.println("ID TERCEROOOOOOOOOOOOOOOOOOOOOOOOO: "+idTercero);
       System.out.println("TAMANOOOOOOOOOOOOOOOOOOOOOO CONTACTOSSSSS: "+contactos.size());
        for (Contacto c : contactos) {
           
            if(c.getIdtercero().getIdtercero().equals(idTercero)){
                contEnviar.add(c);
            }
                }
        //contactos=query.getResultList();
        
        return contEnviar;

    }
    
}
