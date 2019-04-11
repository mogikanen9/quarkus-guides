package org.acme.persistence;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/santa")
public class SantaClausResource {

    @Inject
    SantaClausService service;

    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/gift/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift findGift(@PathParam("id") Long id) {
        return service.findGift(id);
    }

    @POST
    @Path("/gift")
    @Produces(MediaType.APPLICATION_JSON)
    public void createGift() {
        service.createGift("some desc");
    }
}