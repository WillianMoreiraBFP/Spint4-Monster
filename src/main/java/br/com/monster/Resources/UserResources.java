package br.com.monster.Resources;

import br.com.monster.Service.UserService;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/usuarios")
public class UserResources {


    @POST
    @Path("/cadastro")
    public Response cadastrar(Cadastro cadastro) {
        UserService user = new UserService ();

        try{
            Login login = user.cadastro (cadastro);
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
    @Path("/login")
    public Response login(Login login) {
        UserService userService = new UserService ();

        try {
            Login login2 = userService.login(login.getEmail(), login.getSenha()); // Este método preenche o objeto user

            // Retorne os dados do login como JSON
            return Response.ok(login2).build(); // Retorna o objeto Login como JSON
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

}
