package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.veiculo.Veiculo;

import java.sql.SQLException;
import java.util.List;

public class VeiculoService {
    DAO d = new DAO();

    public List<Veiculo> listarVeiculo (int id) throws SQLException{
        List<Veiculo> v;

        v = d.getListaVeiculo(id);

        return v;
    }

    public void cadastarVeiculo(Veiculo veiculo) throws SQLException{

        d.cadastroVeiculo(veiculo);

    }

    public void delete (String placa) throws SQLException{
        d.deleteVeiculo(placa);

    }


}
