/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.controller.Impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.service.SportService;
import pe.com.unmsm.sgojp.api.service.impl.SportServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("sport")
public class SportControllerImpl {
    private static SportService u = new SportServiceImpl();
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        return Response.ok(u.getAll()).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("id") String id) {
        return Response.ok(u.get(id)).build();
    }
}
