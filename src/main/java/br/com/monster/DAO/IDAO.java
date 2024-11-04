package br.com.monster.DAO;

import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;
import br.com.monster.model.veiculo.Veiculo;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {

    // Métodos para gerenciamento de usuários
    void cadastro(Cadastro user) throws SQLException;
    void login(Login user) throws SQLException;
    Login getDados(String email) throws SQLException;
    void updateNome(String email, String nome) throws SQLException;
    void updateSenha(String email, String senha) throws SQLException;
    void updateTel(String email, String telefone) throws SQLException;
    void updatetCep(String email, String cep) throws SQLException;
    void updatetEmail(String email2, String email) throws SQLException;
    void deleteUser(String email) throws SQLException;

    // Métodos para gerenciamento de veículos
    void cadastroVeiculo(Veiculo veiculo, int id) throws SQLException;
    List<Veiculo> getListaVeiculo(int id) throws SQLException;
    void deleteVeiculo(String placa) throws SQLException;
}
