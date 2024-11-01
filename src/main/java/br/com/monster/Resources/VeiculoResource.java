package br.com.monster.Resources;

import br.com.monster.Service.VeiculoService;
import br.com.monster.model.veiculo.Veiculo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("veiculos")
public class VeiculoResource {
    VeiculoService veiculoService = new VeiculoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar/{email}")
    public Response listarVeiculos(@PathParam("email")String email) {
        try {
            List<Veiculo> list = veiculoService.listarVeiculo(email);

            return Response.ok(list).build();


        } catch (SQLException e) {
            System.out.printf(String.valueOf(e));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Erro de SQL: " + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            System.out.printf(String.valueOf(e));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Erro inesperado: " + e.getMessage() + "\"}").build();
        }
    }


    @POST
    @Path("cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastarVeiculo(Veiculo veiculo){
        try {
            veiculoService.cadastarVeiculo(veiculo);
            return Response.accepted().build();
        } catch (SQLException e) {
            System.out.printf(String.valueOf(e));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{\"error\":\"Erro inesperado: " + e.getMessage() + "\"}").build();

        }
    }

    @DELETE
    @Path("delete/{placa}")
    public Response deleteVeiculo(@PathParam("placa") String placa){
        try {
            veiculoService.delete(placa);
            return Response.noContent().build();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
