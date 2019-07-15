package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.dao.impl.FactoryDAO;
import pe.com.unmsm.sgojp.api.model.Place;

import pe.com.unmsm.sgojp.api.service.PlaceService;
import pe.com.unmsm.sgojp.api.service.impl.PlaceServiceImpl;

/**
 *
 * @author Miguel
 */
@Path("place")
public class PlaceControllerImpl {
    private static PlaceService u = new PlaceServiceImpl();
  
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
    
    @GET
    @Path("/filter/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilterCode(@PathParam("code") String code) {
        List<Place> lsPlace = u.getAll();
        FactoryDAO.getUserDAO().get(code);
        
        return Response.ok(u.get(code)).build();
    }
}
