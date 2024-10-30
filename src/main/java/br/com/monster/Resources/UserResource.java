package br.com.monster.Resources;

import br.com.monster.Service.UserService;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;


@Path("usuarios")
public class UserResource {


    @POST
    @Path("cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Cadastro cadastro) {
        UserService userService = new UserService ();

        try{
            Login login = userService.cadastroService (cadastro);
            return Response.ok (login).build ();

        } catch (SQLException e) {
            if (e.getErrorCode () == 1) {
                return Response.status (Response.Status.CONFLICT)
                        .entity ("{\"error\":\"Usuário já cadastrado.\"}")
                        .build ();
            } else {
                return Response.status (Response.Status.INTERNAL_SERVER_ERROR)
                        .entity ("{\"error\":\"Erro inesperado: " + e.getMessage () + "\"}")
                        .build ();
            }
        }
    }


    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Login user) {
        UserService userService = new UserService ();

        try {
            Login login = userService.loginService (user);

            return Response.ok(login).build();
        }catch (SQLException e) {
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
    @Path("getDados/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDados(@PathParam("email") String email) {
        UserService userService = new UserService ();

        try {
            Login login = userService.getService (email);
            return Response.ok (login).build ();

        } catch (SQLException e) {
            return Response.status (Response.Status.NOT_FOUND)
                    .entity ("{\"error\":\"Usuário não encontrado.\"}")
                    .build ();
        } catch (Exception e) {
            return Response.status (Response.Status.INTERNAL_SERVER_ERROR).build ();
        }
    }



    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Login user) {
        UserService userService = new UserService ();

        try {
            userService.updateService (user);
            return Response.accepted ().build ();
        } catch (SQLException e) {
            return Response.status (Response.Status.BAD_REQUEST)
                    .entity ("{\"error\":\"Erro ao atualizar dados.\"}")
                    .build ();
        }
    }

    @DELETE
    @Path ("delete/{email}")
    public Response delete(@PathParam ("email")String email){
        UserService userService = new UserService ();

        try {
            userService.deleteService (email);
            return Response.noContent ().build ();
        } catch (SQLException e) {
            return Response.status (Response.Status.NOT_FOUND)
                    .entity ("{\"error\":\"Usuário não encontrado.\"}")
                    .build ();
        }
    }

}
