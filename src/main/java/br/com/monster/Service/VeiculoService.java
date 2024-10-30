package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Login;
import br.com.monster.model.veiculo.Veiculo;

import java.sql.SQLException;
import java.util.List;

public class VeiculoService {
    DAO d = new DAO();

    public List<Veiculo> listarVeiculo (String email) throws SQLException{
        List<Veiculo> v;
        Login login = d.getDados (email);

        v = d.getListaVeiculo(login.getId ());

        return v;
    }

    public void cadastarVeiculo(Veiculo veiculo) throws SQLException{

        Login login = d.getDados (veiculo.getEmail ());
        d.cadastroVeiculo(veiculo, login.getId ());

    }

    public void delete (String placa) throws SQLException{
        d.deleteVeiculo(placa);

    }


}
