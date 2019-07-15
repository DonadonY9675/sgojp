package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.model.Credential;

import pe.com.unmsm.sgojp.api.service.CredentialService;
import pe.com.unmsm.sgojp.api.service.impl.CredentialServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("credential")
public class CredentialControllerImpl {
    private static CredentialService u = new CredentialServiceImpl();
    
    @POST
    @Path("/verify")
     @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCliente(Map<String,String> credentials) {
        return Response.ok(u.verificar(credentials.get("user"), credentials.get("password"))).build();
    }
    
}
