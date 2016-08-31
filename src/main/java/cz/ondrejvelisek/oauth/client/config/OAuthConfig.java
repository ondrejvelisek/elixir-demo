package cz.ondrejvelisek.oauth.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestOperations;

import java.util.Arrays;

/**
 * @author Ondrej Velisek <ondrejvelisek@gmail.com>
 */
@Configuration
@EnableOAuth2Client
public class OAuthConfig {

    private final String AUTHORIZATION_ENDPOINT = "https://perun.elixir-czech.cz/oidc/authorize";
    private final String TOKEN_ENDPOINT = "https://perun.elixir-czech.cz/oidc/token";
    private final String CLIENT_ID = "client";
    private final String CLIENT_SECRET = "secret";
    private final String[] SCOPES = {"openid","profile","email","phone","bona_fide_status"};

    @Bean
    public RestOperations elixirAAI(OAuth2ClientContext oauth2ClientContext) {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setUserAuthorizationUri(AUTHORIZATION_ENDPOINT);
        resource.setAccessTokenUri(TOKEN_ENDPOINT);
        resource.setClientId(CLIENT_ID);
        resource.setClientSecret(CLIENT_SECRET);
        resource.setScope(Arrays.asList(SCOPES));
        return new OAuth2RestTemplate(resource, oauth2ClientContext);
    }
}
