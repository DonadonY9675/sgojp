/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.controller.Impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.model.service.Opinion;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
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
    public Response getSport() {
        return Response.ok(u.getAll()).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSports(@PathParam("id") String id) {
        return Response.ok(u.get(id)).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOpinion(Sport s) {
        System.out.println("UPDATE");
        return Response.ok(u.update(s)).build();
    }
    
    @GET
    @Path("/filter/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFilterCode(@PathParam("code") String code) {
        return Response.ok(u.getSportFilterCode(code)).build();
    }
}
