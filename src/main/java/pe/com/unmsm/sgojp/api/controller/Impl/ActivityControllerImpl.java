package pe.com.unmsm.sgojp.api.controller.Impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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


/**
 *
 * @author Miguel
 */
@Path("activity")
public class ActivityControllerImpl {

    static ActivityDAO a = new ActivityDAOImpl();

    private static List<Activity> ls = a.getAll();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivityes() {
        return Response.ok(ls).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActivity(@PathParam("id") int id) {

        return Response.ok(ls.get(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeActivity(@PathParam("id") int id) {

//        return Response.ok(ls).build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerActivity(Activity activity) {
        System.out.println(activity);
        ls.add(activity);
        return Response.status(Response.Status.CREATED).entity(activity).build();
    }
}
