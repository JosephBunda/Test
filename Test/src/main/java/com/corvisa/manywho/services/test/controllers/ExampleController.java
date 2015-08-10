package com.corvisa.manywho.services.test.controllers;

import com.corvisa.manywho.services.test.EmailSender;
import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.EngineValueCollection;
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

        String sender           = "";
        String recipients       = "";
        String ccRecipients     = "";
        String bccRecipients    = "";
        String subject          = "";
        String body             = "";

        // I assume that parameters can be gotten from this object.
        EngineValueCollection inputs = serviceRequest.getInputs();
        for (EngineValue value : inputs) {
            String name = value.getDeveloperName();
            switch (name) {
                case "Sender":
                    sender = value.getContentValue();
                    break;
                case "Recipients":
                    recipients = value.getContentValue();
                    break;
                case "CC Recipients":
                    ccRecipients = value.getContentValue();
                    break;
                case "BCC Recipients":
                    bccRecipients = value.getContentValue();
                    break;
                case "Subject":
                    subject = value.getContentValue();
                    break;
                case "Body":
                    body = value.getContentValue();
                    break;
            }
        }


        EmailSender.sendEmail(sender, recipients, ccRecipients, bccRecipients, subject, body);

        return new ServiceResponse(InvokeType.Forward, serviceRequest.getToken());
    }
}
