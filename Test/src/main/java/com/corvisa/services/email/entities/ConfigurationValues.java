package com.corvisa.services.email.entities;

import com.manywho.sdk.services.annotations.Property;

public class ConfigurationValues {

    public final static String SMTP_URI = "SMTP Uri";
    public final static String USERNAME = "Username";
    public final static String PASSWORD = "Password";

    @Property(SMTP_URI)
    private String smtpUri;

    @Property(USERNAME)
    private String username;

    @Property(PASSWORD)
    private String password;

    public String getSmtpUri() {
        return smtpUri;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}