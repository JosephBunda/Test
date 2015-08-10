package com.corvisa.manywho.services.test.oauth2;

import com.manywho.sdk.services.oauth.*;
import org.scribe.model.OAuthConfig;

/**
 * Created by joseph.bunda on 8/4/2015.
 */
public class GitHubProvider extends AbstractOauth2Provider {

    @Override
    public String getName () {
        return "GitHub";
    }


    @Override
    public String getClientId () {
        return "35d99ff963be6f7845ea";
    }


    @Override
    public String getClientSecret () {
        return "a859b3e23ce3a352172b210c295cdfd1986f13b9";
    }


    @Override
    public String getRedirectUri () {
        return "https://flo.manywho.com/api/run/1/oauth2";
    }


    @Override
    public String getAccessTokenEndpoint () {
        return "https://github.com/login/oauth/access_token";
    }


    @Override
    public String getAuthorizationUrl (OAuthConfig config) {
        return String.format("https://github.com/login/oauth/authorize?client_id=%s&redirect_uri=%s", config.getApiKey(), config.getCallback());
    }
}
