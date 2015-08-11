package com.corvisa.services.email.entities;

import com.corvisa.services.email.actions.Email;

import com.manywho.sdk.services.annotations.Property;

import javax.validation.constraints.NotNull;

public class EmailRequest {

    @Property(Email.SENDER)
    @NotNull(message = "You need to include a valid sender.")
    private String sender;

    @Property(Email.RECIPIENTS)
    @NotNull(message = "You need to include a valid recipient.")
    private String recipients;

    @Property(Email.CC_RECIPIENTS)
    private String cc_recipients;

    @Property(Email.BCC_RECIPIENTS)
    private String bcc_recipients;

    @Property(Email.SUBJECT)
    private String subject;

    @Property(Email.BODY)
    private String body;

    public String getSender() { return sender; }

    public String getRecipients() {
        return recipients;
    }

    public String getCCRecipients() {
        return cc_recipients;
    }

    public String getBCCRecipients() {
        return bcc_recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}