package org.triBhaskar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.web.SecurityFilterChain;

import java.util.UUID;

@Configuration
public class AuthorizationServerConfig {

         @Bean
         public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
             OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
             return http
                     .formLogin(Customizer.withDefaults())
                     .build();
         }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient client = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("client")
                .clientSecret("{noop}secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://localhost:9001/login/oauth2/code/client-oidc") // Updated to match Postman's redirect URI
                .scope("openid")
                .scope("api.read")
                .clientSettings(ClientSettings.builder()
                        .requireAuthorizationConsent(true)
//                        .requireProofKey(true) // Enable PKCE
                        .build())
                .build();

        return new InMemoryRegisteredClientRepository(client);
    }
//    @Bean
//    public AuthorizationServerSettings authorizationServerSettings() {
//        return AuthorizationServerSettings.builder()
//                .issuer("http://localhost:9001")
//                .build();
//    }
}
