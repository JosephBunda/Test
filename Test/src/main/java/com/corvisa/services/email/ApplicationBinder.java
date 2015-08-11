package com.corvisa.services.email;

import com.corvisa.services.email.services.EmailService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Created by stevewood on 8/11/15.
 */
public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(EmailService.class).to(EmailService.class);
    }
}
