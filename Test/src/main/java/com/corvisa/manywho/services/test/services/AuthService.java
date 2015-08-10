package com.corvisa.manywho.services.test.services;

import com.manywho.sdk.entities.security.AuthenticatedWhoResult;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import com.manywho.sdk.enums.AuthenticationStatus;
import com.manywho.sdk.services.oauth.OauthProvider;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.User;
import java.io.IOException;

/**
 * Created by joseph.bunda on 8/4/2015.
 */
public class AuthService {

    public AuthenticatedWhoResult authenticateWithGitHub(OauthProvider oauthProvider, OAuthService oauthService, AuthenticationCredentials authenticationCredentials) throws Exception {
        Token accessToken = oauthService.getAccessToken(null, new Verifier(authenticationCredentials.getCode()));
        return createAuthenticatedWhoResult(oauthProvider, accessToken.getToken());
    }

    private AuthenticatedWhoResult createAuthenticatedWhoResult(OauthProvider oauthProvider, String token) throws IOException {
        User user = new UserService(createGitHubClient(token)).getUser();

        return new AuthenticatedWhoResult() {{
            setDirectoryId(oauthProvider.getName());
            setDirectoryName(oauthProvider.getName());
            setEmail(user.getEmail());
            setFirstName(user.getName());
            setIdentityProvider(oauthProvider.getName());
            setLastName(user.getName());
            setStatus(AuthenticationStatus.Authenticated);
            setTenantName(oauthProvider.getClientId());
            setToken(token);
            setUserId(String.valueOf(user.getId()));
            setUsername(user.getLogin());
        }};
    }

    protected GitHubClient createGitHubClient(String token) {
        return new GitHubClient().setOAuth2Token(token);
    }

}
