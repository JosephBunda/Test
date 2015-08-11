package com.corvisa.services.email.actions;

import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.entities.describe.DescribeValue;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.services.describe.actions.AbstractAction;

public class Email extends AbstractAction {

    public final static String SENDER = "Sender";
    public final static String RECIPIENTS = "Recipients";
    public final static String CC_RECIPIENTS = "CC Recipients";
    public final static String BCC_RECIPIENTS = "BCC Recipients";
    public final static String SUBJECT = "Subject";
    public final static String BODY = "Body";

    @Override
    public String getUriPart() {
        return "email";
    }

    @Override
    public String getDeveloperName() {
        return "Send Email";
    }

    @Override
    public String getDeveloperSummary() {
        return "Send an email through any SMTP enabled email provider";
    }

    @Override
    public DescribeValueCollection getServiceInputs() {
        return new DescribeValueCollection() {{
            add(new DescribeValue(SENDER, ContentType.String, true, null, null));
            add(new DescribeValue(RECIPIENTS, ContentType.String, true, null, null));
            add(new DescribeValue(CC_RECIPIENTS, ContentType.String, false, null, null));
            add(new DescribeValue(BCC_RECIPIENTS, ContentType.String, false, null, null));
            add(new DescribeValue(SUBJECT, ContentType.String, false, null, null));
            add(new DescribeValue(BODY, ContentType.Content, true, null, null));
        }};
    }

    @Override
    public DescribeValueCollection getServiceOutputs() {
        return new DescribeValueCollection();
    }
}
