package com.corvisa.manywho.services.controllers;

import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.services.annotations.AuthorizationRequired;
import com.manywho.sdk.services.controllers.AbstractController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/odata")
@Consumes("application/json")
@Produces("application/json")
public class ExampleController extends AbstractController {

    @Path("/odata")
    @POST
    @AuthorizationRequired
    public ServiceResponse odataAction(ServiceRequest serviceRequest) throws Exception {
        return new ServiceResponse(InvokeType.Forward, serviceRequest.getToken());
    }
}
