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

    @GET
    @Path("/search/gift/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift findGiftByName(@PathParam("name") String name) {
        return service.findGiftByName(name).orElse(new Gift());
    }

    @POST
    @Path("/gift/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public void createGift(@PathParam("name") String name) {
        service.createGift(name);
    }
}