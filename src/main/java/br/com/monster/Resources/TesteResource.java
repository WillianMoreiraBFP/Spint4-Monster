package br.com.monster.Resources;

import jakarta.ws.rs.core.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/teste")
public class TesteResource {

    @GET
    public Response testarConexao() {
        return Response.ok("API está funcionando!").build();
    }
}
