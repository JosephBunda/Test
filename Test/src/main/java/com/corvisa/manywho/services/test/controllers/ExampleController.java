package com.corvisa.manywho.services.test.controllers;

import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.services.annotations.AuthorizationRequired;
import com.manywho.sdk.services.controllers.AbstractController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/JoeTest")
@Consumes("application/json")
@Produces("application/json")
public class ExampleController extends AbstractController {

    //@Inject
    //private FooClass foo;

    @Path("/Test")
    @POST
    @AuthorizationRequired
    public ServiceResponse testAction(ServiceRequest serviceRequest) throws Exception {

        //this.foo.doSomething();

        return new ServiceResponse(InvokeType.Forward, serviceRequest.getToken());
    }
}
