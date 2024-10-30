package br.com.monster.CORS;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;


import java.io.IOException;

@Provider
public class CorsFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
    }
}
