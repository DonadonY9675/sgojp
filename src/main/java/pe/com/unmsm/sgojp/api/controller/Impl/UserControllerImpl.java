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
import pe.com.unmsm.sgojp.api.model.User;

import pe.com.unmsm.sgojp.api.service.UserService;
import pe.com.unmsm.sgojp.api.service.impl.UserServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("user")
public class UserControllerImpl {
    private static UserService u = new UserServiceImpl();
  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        return Response.ok(u.getAll()).build();
    }
    
    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("code") String code) {
        return Response.ok(u.get(code)).build();
    }
    
}
