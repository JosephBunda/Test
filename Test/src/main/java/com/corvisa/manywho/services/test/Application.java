package com.corvisa.manywho.services.test;

import com.manywho.sdk.services.BaseApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends BaseApplication {
    public Application() {
        registerSdk()
                .packages("com.corvisa.manywho.services.test")
                .register(new ApplicationBinder());
    }
}
