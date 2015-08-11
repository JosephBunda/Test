package com.corvisa.manywho.services;

import com.manywho.sdk.services.BaseApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends BaseApplication {
    public Application() {
        registerSdk()
                .packages("com.corvisa.manywho.services")
                .register(new ApplicationBinder());
    }
}
