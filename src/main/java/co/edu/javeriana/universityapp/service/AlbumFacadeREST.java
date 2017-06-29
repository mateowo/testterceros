/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.universityapp.service;

import co.edu.javeriana.universityapp.entity.Student;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("albums")
public class AlbumFacadeREST {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Album find(@PathParam("id") Long id) {
        return null;
        // returns the album from the database
    }

}
