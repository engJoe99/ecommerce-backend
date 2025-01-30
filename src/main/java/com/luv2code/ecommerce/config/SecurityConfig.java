package com.luv2code.ecommerce.config;


import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configure API endpoint security - require authentication for /api-orders/** and allow public access to other endpoints
        // This ensures that any requests to paths starting with /api-orders/ require valid authentication
        // All other request paths will be publicly accessible without authentication
        http.authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/api-orders2/**")
                                .authenticated()
                                .anyRequest().permitAll())
                //This sets up the application to accept JWT tokens (like a special digital ticket) from Okta for authentication.
                .oauth2ResourceServer(oauth2ResourceServer ->
                        oauth2ResourceServer.jwt(Customizer.withDefaults()));

        // Enable CORS (Cross-Origin Resource Sharing) support to allow requests from different domains
        // Uses default CORS configuration which can be customized if needed
        http.cors(Customizer.withDefaults());

        // Configure content negotiation strategy to determine a response format based on request headers
        // HeaderContentNegotiationStrategy uses the Accept header to negotiate content type
        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        // Configure Okta's 401 response handler for unauthorized requests
        // This customizes the response body when authentication fails or is missing
        Okta.configureResourceServer401ResponseBody(http);

        // Disable CSRF (Cross-Site Request Forgery) protection
        // This is safe to disable when using stateless JWT tokens for authentication
        // as they provide their own protection against CSRF attacks
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
