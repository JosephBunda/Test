package com.corvisa.manywho.services.test.actions;

import com.manywho.sdk.entities.describe.DescribeValue;
import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.describe.actions.AbstractAction;
import com.corvisa.manywho.services.test.types.ExampleOne;

public class Example extends AbstractAction {
    @Override
    public String getUriPart() {
        return "JoeTest/Test";
    }

    @Override
    public String getDeveloperName() {
        return "Joe's Test";
    }

    @Override
    public String getDeveloperSummary() {
        return "This is an test action for a Service";
    }

    @Override
    public DescribeValueCollection getServiceInputs() {
        return new DescribeValueCollection() {{
            add(new DescribeValue("Example One", ContentType.Object, true, null, ExampleOne.NAME));
        }};
    }

    @Override
    public DescribeValueCollection getServiceOutputs() {
        return new DescribeValueCollection() {{
            add(new DescribeValue("Created?", ContentType.Boolean, true));
        }};
    }
}
