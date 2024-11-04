package br.com.monster.DAO;

import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import br.com.monster.model.veiculo.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IDAO {
    ConexaoJDBC conexaoJDBC = new ConexaoJDBC();

    //User:Cadastro/Login

    //Classe Cadastro
    public void cadastro(Cadastro user) throws SQLException {
        String sql = "INSERT INTO t_user (user_name, senha, telefone, email, cep) VALUES (?, ?, ?, ?, ?) ";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getSenha());
        statement.setString(3, user.getTelefone());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getCep());
        statement.execute();

        statement.close();
        conexao.close();

    }

    //Classe Login
    public void login(Login user) throws SQLException {
        String sql = "SELECT id_user, user_name, senha, telefone, email, cep FROM t_user WHERE email = ? AND senha = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getSenha());
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            user.setId(result.getInt(1));
            user.setUserName(result.getString(2));
            user.setSenha(result.getString(3));
            user.setTelefone(result.getString(4));
            user.setEmail(result.getString(5));
            user.setCep(result.getString(6));
        } else {
            throw new SQLException();
        }

        result.close();
        statement.close();
        conexao.close();
    }

    public Login getDados(String email) throws SQLException {
        String sql = "SELECT id_user, user_name, telefone, email, cep, senha FROM t_user WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString (1, email);
        ResultSet result = statement.executeQuery();

        Login login = new Login();

        if (result.next()) {
            login.setId(result.getInt(1));
            login.setUserName(result.getString(2));
            login.setTelefone(result.getString(3));
            login.setEmail(result.getString(4));
            login.setCep(result.getString(5));
            login.setSenha(result.getString(6));
        } else {
            System.out.println("Nenhum dado encontrado");
        }

        result.close();
        statement.close();
        conexao.close();

        return login;
    }

    public void updateNome(String email, String nome) throws SQLException {
        String sql = "UPDATE t_user SET user_name = ? WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString (2, email);
        statement.execute();

        statement.close();
        conexao.close();

    }

    public void updateSenha(String email, String senha) throws SQLException {
        String sql = "UPDATE t_user SET senha = ? WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, senha);
        statement.setString (2, email);
        statement.execute();

        statement.close();
        conexao.close();

    }

    public void updateTel(String email, String telefone) throws SQLException {
        String sql = "UPDATE t_user SET telefone = ? WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, telefone);
        statement.setString (2, email);
        statement.execute();

        statement.close();
        conexao.close();

    }

    public void updatetCep(String email, String cep) throws SQLException {
        String sql = "UPDATE t_user SET cep = ? WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, cep);
        statement.setString (2, email);
        statement.execute();

        statement.close();
        conexao.close();

    }


    public void updatetEmail(String email2, String email) throws SQLException {
        String sql = "UPDATE t_user SET email = ? WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString (2, email2);
        statement.execute();

        statement.close();
        conexao.close();
    }

    public void deleteUser(String email) throws SQLException {
        String sql = "DELETE FROM t_user WHERE email = ?";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString (1, email);
        statement.execute();

        statement.close();
        conexao.close();

    }

    //Veiculo:Veiculo/CadastroVeiculo

    //Cadastro

    public void cadastroVeiculo(Veiculo veiculo, int id) throws SQLException {
        Veiculo v = new Veiculo();

        String sql = "INSERT INTO t_veiculo (marca, modelo, ano, placa, id_user) VALUES (?, ?, ?, ?, ?) ";

        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement(sql);

        statement.setString(1, veiculo.getMarca());
        statement.setString(2, veiculo.getModelo());
        statement.setInt(3, veiculo.getAno());
        statement.setString(4, veiculo.getPlaca());
        statement.setInt (5, id);

        statement.executeUpdate();

        statement.close();
        conexao.close();

    }

    //Veiculo

    public List<Veiculo> getListaVeiculo(int id) throws SQLException {

        List<Veiculo> v = new ArrayList<>();

        String instrucaoSQL = "SELECT  marca, modelo, ano, placa, id_veiculo FROM t_veiculo WHERE id_user = " + id;
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        Statement statement = conexao.createStatement();
        ResultSet result = statement.executeQuery(instrucaoSQL);

        while (result.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setMarca(result.getString(1));
            veiculo.setModelo(result.getString(2));
            veiculo.setAno(result.getInt(3));
            veiculo.setPlaca(result.getString(4));
            veiculo.setId(result.getInt(5));
            v.add(veiculo);
        }
        return v;
    }

    public void deleteVeiculo(String placa) throws SQLException {
        String sql = "DELETE FROM t_veiculo WHERE placa = " + "'" + placa + "'";
        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        Statement statement = conexao.createStatement();
        statement.executeUpdate(sql);

        statement.close();
        conexao.close();

    }
}

