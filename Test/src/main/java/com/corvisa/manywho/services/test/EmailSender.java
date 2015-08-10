package com.corvisa.manywho.services.test;

/**
 * Created by joseph.bunda on 8/10/2015.
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSender {

    public static void sendEmail (String sender, String recipients, String ccRecipients, String bccRecipients, String subject, String body) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.google.com");

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipients(Message.RecipientType.TO, recipients);
            message.addRecipients(Message.RecipientType.CC, ccRecipients);
            message.addRecipients(Message.RecipientType.BCC, bccRecipients);
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
