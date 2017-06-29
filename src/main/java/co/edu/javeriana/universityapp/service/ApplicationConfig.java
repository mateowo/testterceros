/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jpavlich
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.javeriana.universityapp.service.AlbumFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.CiudadFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.ClasificacionFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.ContactoFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.CourseFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.CourseSectionFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.DireccionesterceroFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.StudentFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.TerceroFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.TipocontribuyenteFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.TipoidentificacionFacadeREST.class);
        resources.add(co.edu.javeriana.universityapp.service.TipoterceroFacadeREST.class);
    }
    
}
