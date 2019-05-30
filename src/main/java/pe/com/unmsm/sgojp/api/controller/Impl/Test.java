/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.controller.Impl;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pe.com.unmsm.sgojp.api.dao.ActivityDAO;
import pe.com.unmsm.sgojp.api.dao.impl.ActivityDAOImpl;
import pe.com.unmsm.sgojp.api.model.Activity;
import pe.com.unmsm.sgojp.api.model.User;

/**
 *
 * @author usuario
 */
@Path("/test")
public class Test {
    
    static ActivityDAO a = new ActivityDAOImpl();

    private static List<Activity> ls = a.getAll();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivityes() {
        System.out.println("GET Activity");
        return Response.ok(ls).build();
    }
    
    @GET
    @Path("/{file}")
    public String prueba(@PathParam("file") final String file){
        return file;
    }
//    @POST
//    @Path("/post")
//    public User pruebaPost(@RequestBody User user){
//        return user;
//    }
    @POST
    @Path("/post/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerActivity(Activity activity) {
        System.out.println("POST Activity");
        System.out.println(activity);
        return Response.status(Response.Status.CREATED).entity(activity).build();
    }
}
