package com.corvisa.services.email;

import com.manywho.sdk.services.BaseApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends BaseApplication {
    public Application() {
        registerSdk().packages("com.corvisa.services.email")
                .register(new ApplicationBinder());
    }
}
