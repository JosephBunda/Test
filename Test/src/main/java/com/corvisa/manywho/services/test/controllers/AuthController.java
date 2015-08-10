package com.corvisa.manywho.services.test.controllers;

import com.corvisa.manywho.services.test.services.AuthService;
import com.manywho.sdk.entities.security.AuthenticatedWhoResult;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import com.manywho.sdk.services.controllers.AbstractOauth2Controller;
import com.manywho.sdk.services.oauth.AbstractOauth2Provider;

import javax.inject.Inject;

/**
 * Created by joseph.bunda on 8/4/2015.
 */
public class AuthController extends AbstractOauth2Controller {

    @Inject
    private AuthService authService;

    public AuthController (AbstractOauth2Provider oauth2Provider) {
        super(oauth2Provider);
    }

    @Override
    public AuthenticatedWhoResult authentication (AuthenticationCredentials authenticationCredentials) throws Exception {
        return authService.authenticateWithGitHub(oauth2Provider, getOauthService(), authenticationCredentials);
    }
}
