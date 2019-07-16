package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.service.QuerysService;
import pe.com.unmsm.sgojp.api.service.impl.QuerysServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("query")
public class QueryControllerImpl {

    private static QuerysService u =  new QuerysServiceImpl();

    @GET
    @Path("/most-rated-games")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMostRatedGames() {
        return Response.ok(u.getMostRatedGames()).build();
    }

    @GET
    @Path("/better-qualified-services")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBetterQualifiedServices() {
        return Response.ok(u.getBetterQualifiedServices()).build();
    }
    
}
