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

    public List<Veiculo> cadastarVeiculo(int id, Veiculo veiculo) throws SQLException{
        List<Veiculo> v;

        d.cadastroVeiculo(veiculo);
        v = d.getListaVeiculo(id);

        return v;
    }

    public List<Veiculo> delete (int id) throws SQLException{
        List<Veiculo> v;

        d.deleteVeiculo(id);
        v = d.getListaVeiculo(id);

        return v;
    }


}
