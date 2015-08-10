package com.corvisa.manywho.services.test.types;

import com.manywho.sdk.entities.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyCollection;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.describe.types.AbstractType;

public class ExampleTwo extends AbstractType {
    public final static String NAME = "JoeTest Example Two";

    @Override
    public String getDeveloperName() {
        return NAME;
    }

    @Override
    public TypeElementPropertyCollection getProperties() {
        return new TypeElementPropertyCollection() {{
            add(new TypeElementProperty("Another Property One", ContentType.Number));
        }};
    }


    // Look up TypeElementBindings for database-related activities. - Joe
}
