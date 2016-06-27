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

    private final String AUTHORIZATION_ENDPOINT = "https://perun-dev.meta.zcu.cz/krb/oauth2/authorize";
    private final String TOKEN_ENDPOINT = "https://perun-dev.meta.zcu.cz/oauth2/token";
    private final String CLIENT_ID = "beacon-test-service2";
    private final String CLIENT_SECRET = "2af12d71-ede7-4944-998b-8e83125c2eef";

    @Bean
    public RestOperations elixirAAI(OAuth2ClientContext oauth2ClientContext) {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setUserAuthorizationUri(AUTHORIZATION_ENDPOINT);
        resource.setAccessTokenUri(TOKEN_ENDPOINT);
        resource.setClientId(CLIENT_ID);
        resource.setClientSecret(CLIENT_SECRET);
        /* Should be regular List of Strings but current Authorization server expects comma as a divider in param
        instead of proper space which Spring security for OAuth use */
        resource.setScope(Arrays.asList("sub,name,email,bona_fide_status"));
        return new OAuth2RestTemplate(resource, oauth2ClientContext);
    }
}
