/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.controller.Impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author usuario
 */
@Path("/test")
public class Test {
    
    @GET
    @Path("/{file}")
    public String prueba(@PathParam("file") final String file){
        return file;
    }
    
}
