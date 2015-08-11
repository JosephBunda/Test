package com.corvisa.services.email.controllers;

import com.corvisa.services.email.entities.ConfigurationValues;
import com.corvisa.services.email.entities.EmailRequest;
import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.services.annotations.AuthorizationRequired;
import com.manywho.sdk.services.controllers.AbstractController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Properties;

@Path("/actions")
@Consumes("application/json")
@Produces("application/json")
public class InvokeController extends AbstractController {

    @Path("/email")
    @POST
    @AuthorizationRequired
    public ServiceResponse sendEmail(ServiceRequest serviceRequest) throws Exception {

        ConfigurationValues configurationValues = this.parseConfigurationValues(serviceRequest, ConfigurationValues.class);
        EmailRequest emailRequest = this.parseInputs(serviceRequest, EmailRequest.class);

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", configurationValues.getSmtpUri());
        properties.setProperty("mail.user", configurationValues.getUsername());
        properties.setProperty("mail.password", configurationValues.getPassword());

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRequest.getSender()));
            message.addRecipients(Message.RecipientType.TO, emailRequest.getRecipients());
            message.addRecipients(Message.RecipientType.CC, emailRequest.getCCRecipients());
            message.addRecipients(Message.RecipientType.BCC, emailRequest.getBCCRecipients());
            message.setSubject(emailRequest.getSubject());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailRequest.getBody());

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ServiceResponse(InvokeType.Forward, serviceRequest.getToken());
    }
}
