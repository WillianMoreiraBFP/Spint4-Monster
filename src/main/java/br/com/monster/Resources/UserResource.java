package br.com.monster.Resources;

import br.com.monster.Service.UserService;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("usuarios")
public class UserResource {


    @POST
    @Path("cadastro")
    public Response cadastrar(Cadastro cadastro) {
        UserService userService = new UserService ();

        try{
            Login login = userService.cadastroService (cadastro);
            return Response.ok (login).build ();

        } catch (SQLException e){
            if (e.getErrorCode() == 1) { // ORA-00001: unique constraint violated
                return Response.status(Response.Status.CONFLICT).build(); // 409 Conflict
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Erro inesperado: " + e.getMessage() + "\"}").build(); // 500 Internal Server Error
            }
        }
    }


    @POST
    @Path("login")
    public Response login(Login user) {
        UserService userService = new UserService ();

        try {
            Login login = userService.loginService (user); // Este método preenche o objeto user

            // Retorne os dados do loginService como JSON
            return Response.ok(login).build(); // Retorna o objeto Login como JSON
        } catch (SQLException e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\":\"Usuário não encontrado ou senha incorreta.\"}")
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\":\"Erro inesperado: " + e.getMessage() + "\"}")
                    .build();
        }
    }

    @GET
    @Path("getDados/{id}")
    public Response getDados(@PathParam ("id")int id){
        UserService userService = new UserService ();

        try {
            Login login = userService.getService(id);
            return Response.ok(login).build();

        } catch (SQLException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }



    @POST
    @Path ("update")
    public Response update(Login user){
        UserService userService = new UserService ();

        try {
            userService.updateService (user);
            return Response.accepted().build();
        } catch (SQLException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build ();
        }

    }

    @DELETE
    @Path ("delete/{id}")
    public Response delete(@PathParam ("id")int id){
        UserService userService = new UserService ();

        try {
            userService.deleteService (id);
            return Response.noContent ().build ();
        } catch (SQLException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build ();
        }
    }

}
