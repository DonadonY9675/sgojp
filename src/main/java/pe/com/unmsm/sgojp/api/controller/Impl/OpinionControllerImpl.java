package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.model.service.Opinion;
import pe.com.unmsm.sgojp.api.service.OpinionService;
import pe.com.unmsm.sgojp.api.service.impl.OpinionServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("opinion")
public class OpinionControllerImpl {

    private static OpinionService u = new OpinionServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOpinion() {
        return Response.ok(u.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOpinion(@PathParam("id") String code) {
        return Response.ok(u.get(code)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerOpinion(Opinion o) {
        System.out.println("REGISTRANDO");
        return Response.status(Response.Status.CREATED).entity(u.register(o)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOpinion(Opinion o) {
        System.out.println("UPDATE");
        return Response.ok(u.update(o)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeOpinion(@PathParam("id") String id) {
        System.out.println("REMOVE");
        return Response.ok(u.remove(id)).build();
    }

}
