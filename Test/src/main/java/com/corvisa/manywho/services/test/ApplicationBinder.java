package com.corvisa.manywho.services.test;

import com.corvisa.manywho.services.test.services.AuthService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(AuthService.class).to(AuthService.class);
    }
}
