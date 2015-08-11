package com.corvisa.manywho.services.types;

import com.manywho.sdk.entities.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyCollection;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.describe.types.AbstractType;

public class ExampleOne extends AbstractType {
    public final static String NAME = "Example One";

    @Override
    public String getDeveloperName() {
        return NAME;
    }

    @Override
    public TypeElementPropertyCollection getProperties() {
        return new TypeElementPropertyCollection() {{
            add(new TypeElementProperty("Property One", ContentType.String));
            add(new TypeElementProperty("Example Two", ContentType.Object, ExampleTwo.NAME));
        }};
    }
}
