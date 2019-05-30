package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.service.QuestionService;
import pe.com.unmsm.sgojp.api.service.impl.QuestionServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("question")
public class QuestionControllerImpl {

    private static QuestionService u = new QuestionServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        return Response.ok(u.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("id") String code) {
        return Response.ok(u.get(code)).build();
    }

}
