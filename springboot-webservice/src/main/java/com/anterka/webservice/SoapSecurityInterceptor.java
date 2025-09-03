package com.anterka.webservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

public class SoapSecurityInterceptor implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        // Get the HTTP request from transport context
        TransportContext transportContext = TransportContextHolder.getTransportContext();
        if (transportContext != null && transportContext.getConnection() instanceof HttpServletConnection) {
            HttpServletConnection connection = (HttpServletConnection) transportContext.getConnection();
            HttpServletRequest request = connection.getHttpServletRequest();

            // Check if user is authenticated
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                // Log the authenticated user
                System.out.println("SOAP request authenticated for user: " + authentication.getName());
                return true;
            }
        }

        return false; // Block unauthenticated requests
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        // Cleanup if needed
    }
}
