package com.corvisa.manywho.services.controllers;

import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;

import javax.ws.rs.*;

@Path("/")
@Consumes("application/json")
@Produces("application/json")
public class DataController {

    @Path("/data")
    @POST
    public ObjectDataResponse load(ObjectDataRequest objectDataRequest) throws Exception {
        return new ObjectDataResponse();
    }

    @Path("/data")
    @PUT
    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception {
        return new ObjectDataResponse();
    }
}