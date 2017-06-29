/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.service;

import co.edu.javeriana.universityapp.entity.Ciudad;
import co.edu.javeriana.universityapp.entity.Clasificacion;
import co.edu.javeriana.universityapp.entity.Tercero;
import co.edu.javeriana.universityapp.entity.Tipoidentificacion;
import co.edu.javeriana.universityapp.entity.Tipotercero;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariajosemendoza
 */
@Stateless
@Path("tercero")
public class TerceroFacadeREST extends AbstractFacade<Tercero> {

    @EJB
    private ClasificacionFacadeREST clasificacionFacadeREST;
    
    @EJB
    private TipoidentificacionFacadeREST tipoidentificacionFacadeREST;

    @EJB
    private CiudadFacadeREST ciudadFacadeREST;

    @PersistenceContext(unitName = "co.edu.javeriana_UniversityApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public TerceroFacadeREST() {
        super(Tercero.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tercero entity) {
        System.out.println("Fecha: "+ entity.getFechaCreacion() );
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Tercero entity) {
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
    public Tercero find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tercero> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tercero> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getId() throws InterruptedException {

        Thread.sleep(500);
        List<Tercero> lista = super.findAll();
        int max = 0;
        for (Tercero t : lista) {
            if (t.getIdtercero() > max) {
                max = t.getIdtercero();
            }
        }
        return max + 1;

    }


    @GET
    @Path("asociarTerceroCiudad/{idTercero}/{idCiudad}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asociarTercCiudad(@PathParam("idTercero") Integer idTercero, @PathParam("idCiudad") Integer idCiudad) throws InterruptedException {

        Thread.sleep(500);
        Tercero t = find(idTercero);
        Ciudad c = ciudadFacadeREST.find(idCiudad);
        t.setIdciudad(c);
        em.persist(t);
    }

    @GET
    @Path("asociarTerceroTipo/{idTercero}/{idTipo}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asociarTercTipo(@PathParam("idTercero") Integer idTercero, @PathParam("idTipo") Integer idTipo) throws InterruptedException {

        Thread.sleep(500);
        Tercero t = find(idTercero);
        Tipoidentificacion ti = tipoidentificacionFacadeREST.find(idTipo);
        t.setIdtipo(ti);
        em.persist(t);
        
        /*Query q = em.createQuery("SELECT COUNT(t) FROM Tercero t WHERE t.IDTERCERO=:idTercero AND t.IDTIPO=:idTipo");
        q.setParameter("idTercero", idTercero);
        q.setParameter("idTipo", idTipo);
        System.out.println("QUERYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"+q.toString());
        int cant=(int)q.getSingleResult();  
        Tercero t = find(idTercero);
        if(cant>0){
          
            Tipoidentificacion ti = tipoidentificacionFacadeREST.find(idTipo);
            t.setIdtipo(ti);
            em.persist(t);
        }
        else{
            em.remove(t);
            System.out.println("REPETIDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO------------------------------------------------");
        }
        List<Tercero> lista = super.findAll();
        
        for(Tercero ter : lista){
            if(t.getIdentificacion() == ter.getIdentificacion() )
        }*/

    }
    
    
    @GET
    @Path("asociarTerceroFecha/{idTercero}/{fecha}")
    @Produces(MediaType.TEXT_PLAIN)
    public void asociarTercCiudad(@PathParam("idTercero") Integer idTercero, @PathParam("fecha") String fecha) throws InterruptedException {

        Thread.sleep(500);
        Tercero t = find(idTercero);
        Date d = Date.valueOf(fecha);
        t.setFechaCreacion(d);
        System.out.println(d);
        em.persist(t);
    }
    
        
    @GET
    @Path("vendedor")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tercero> findVendedor() {
        List<Tercero> todos = super.findAll();
        List<Tercero> vendedores = new ArrayList<>();
        List<Tipotercero> lista = new ArrayList<>();
        for (Tercero t : todos) {
            lista = t.getTipoterceroList();
            for (Tipotercero ti : lista) {
                if(ti.getTipotercero().equalsIgnoreCase("vendedor")){
                   vendedores.add(t);
                }
            }
            System.out.println(vendedores.size());
            
        }
        return vendedores;
    }
    
    @XmlRootElement
    public class MyJaxBean {
        @XmlElement public String param1;
        @XmlElement public String param2;
    }
    
    
    @POST
    @Path("asociarTerceroPropiedad/{id}/{clasi1}/{clasi2}/{clasi3}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void asociarTerceroPropiedad(@PathParam("id") Integer id, @PathParam("clasi1") Integer clasi1, @PathParam("clasi2") Integer clasi2, @PathParam("clasi3") Integer clasi3, List<Tipotercero> from) {
        System.out.println(id+" "+clasi1+" "+clasi2+" "+clasi3+" ");
        System.out.println(from.size());
        MyJaxBean m;
        for (Tipotercero tipotercero : from) {
            System.out.println(tipotercero.getTipotercero());
        }
        System.out.println("///////////////////////////////////////////////////////////////////");
        System.out.println("*********************************************************************");
        Tercero t = this.find(id);
        System.out.println(t.getPrimernombre());
        List<Clasificacion> clasificacionList = new ArrayList<>();
        Clasificacion c1 = clasificacionFacadeREST.find(clasi1);
        System.out.println(c1.getNumeroclasificacion());
        clasificacionList.add(c1);
        Clasificacion c2 = clasificacionFacadeREST.find(clasi2);
        System.out.println(c2.getNumeroclasificacion());
        clasificacionList.add(c2);
        Clasificacion c3 = clasificacionFacadeREST.find(clasi3);
        System.out.println(c3.getNumeroclasificacion());
        clasificacionList.add(c3);
        t.setClasificacionList(clasificacionList);
        t.setTipoterceroList(from);
        List<Tercero> terceroList = new ArrayList<>();
        terceroList.add(t);
        c1.setTerceroList(terceroList);
        c2.setTerceroList(terceroList);
        c3.setTerceroList(terceroList);
        System.out.println("///////////////////////////////////////////////////////////////////111");
        System.out.println("*********************************************************************");;
        clasificacionFacadeREST.edit(c1);
        clasificacionFacadeREST.edit(c2);
        clasificacionFacadeREST.edit(c3);
        System.out.println("///////////////////////////////////////////////////////////////////22");
        System.out.println("*********************************************************************");
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            javax.validation.Validator validator = factory.getValidator();

            Set<ConstraintViolation<Tercero>> constraintViolations;
        constraintViolations = validator.validate(t);
            
            if (constraintViolations.size() > 0 ) {
            System.out.println("Constraint Violations occurred..");
            for (ConstraintViolation<Tercero> contraints : constraintViolations) {
            System.out.println(contraints.getRootBeanClass().getSimpleName()+
            "." + contraints.getPropertyPath() + " " + contraints.getMessage());
            }
            }
        
        this.em.persist(t);
        System.out.println("///////////////////////////////////////////////////////////////////33");
        System.out.println("*********************************************************************");
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
