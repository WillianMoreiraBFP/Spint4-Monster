package br.com.monster.DAO;

import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import br.com.monster.model.veiculo.Veiculo;
import br.com.monster.model.veiculo.Historico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    ConexaoJDBC conexaoJDBC = new ConexaoJDBC ();

    //User:Cadastro/Login

    //Classe Cadastro
    public void cadastro(Cadastro user) throws SQLException {
        String sql = "INSERT INTO t_user (user_name, senha, telefone, email, logradouro, bairro, localidade, uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , user.getUserName ());
        statement.setString (2 , user.getSenha ());
        statement.setString (3 , user.getTelefone ());
        statement.setString (4 , user.getEmail ());
        statement.setString (5 , user.getLogradouro ());
        statement.setString (6 , user.getBairro ());
        statement.setString (7 , user.getLocalidade ());
        statement.setString (8 , user.getUf ());
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    //Classe Login
    public void login(Login user ,String email, String senha) throws SQLException {
        String sql = "SELECT id_user, user_name, senha, telefone, email, logradouro, bairro, localidade, uf FROM t_user WHERE email = ? AND senha = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , email);
        statement.setString (2 , senha);
        ResultSet result = statement.executeQuery ();
        while (result.next ()) {
            user.setId (result.getInt (1));
            user.setUserName (result.getString (2));
            user.setSenha (result.getString (3));
            user.setTelefone (result.getString (4));
            user.setEmail (result.getString (5));
            user.setLogradouro (result.getString (6));
            user.setBairro (result.getString (7));
            user.setLocalidade (result.getString (8));
            user.setUf (result.getString (9));
        }

        result.close ();
        statement.close ();
        conexao.close ();
    }

    public void updateSenha(int id, String senha) throws SQLException {
        String sql = "UPDATE t_user SET senha = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , senha);
        statement.setInt (2 , id);
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    public void updateTel(int id, String telefone) throws SQLException {
        String sql = "UPDATE t_user SET telefone = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , telefone);
        statement.setInt (2 , id);
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    public void updatetCep(int id, String logradouro, String bairro, String localidade, String uf) throws SQLException {
        String sql = "UPDATE t_user SET logradouro = ? , bairro = ?, localidade = ?, uf = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , logradouro);
        statement.setString (2 , bairro);
        statement.setString (3 , localidade);
        statement.setString (4 , uf);
        statement.setInt (5 , id);
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    public void updatetEmail(int id, String email) throws SQLException {
        String sql = "UPDATE t_user SET email = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

            PreparedStatement statement = conexao.prepareStatement (sql);
            statement.setString (1 , email);
            statement.setInt (2 , id);
            statement.execute ();

            statement.close ();
            conexao.close ();

    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM t_user WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

            PreparedStatement statement = conexao.prepareStatement (sql);
            statement.setInt (1 , id);
            statement.execute ();

            statement.close ();
            conexao.close ();

    }

    public void deleteTel(int id) throws SQLException{
        String sql = "UPDATE t_user SET telefone = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , null);
        statement.setInt (2 , id);
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    public void deletetCep(int id) throws SQLException {
        String sql = "UPDATE t_user SET cep = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , null);
        statement.setInt (2 , id);
        statement.execute ();

        statement.close ();
        conexao.close ();

    }

    public void deletetEmial(int id) throws SQLException {
        String sql = "UPDATE t_user SET email = ? WHERE id_user = ?";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        PreparedStatement statement = conexao.prepareStatement (sql);
        statement.setString (1 , null);
        statement.setInt (2 , id);
        statement.execute ();


        statement.close ();
        conexao.close ();

    }

    //Veiculo:Veiculo/CadastroVeiculo/Histrorico

    //Cadastro

    public void cadastroVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO t_veiculo (marca, modelo, motor, ano, placa, id_user) VALUES (?, ?, ?, ?, ?, ?)";

        conexaoJDBC.conectar();
        Connection conexao = conexaoJDBC.getConexao();

        PreparedStatement statement = conexao.prepareStatement (sql);

        statement.setString (1 , veiculo.getMarca ());
        statement.setString (2 , veiculo.getModelo ());
        statement.setString (3 , veiculo.getTipoMotor ());
        statement.setInt (4 , veiculo.getAno ());
        statement.setString (5 , veiculo.getPlaca ());
        statement.setInt (6 , veiculo.getIdUser ());

        statement.executeUpdate ();

        statement.close ();
        conexao.close ();

    }

    //Veiculo

    public List<Veiculo> getListaVeiculo(int id ) throws  SQLException {

        List<Veiculo> v = new ArrayList<> ();

        String instrucaoSQL = "SELECT  marca, modelo, motor, ano, placa FROM t_veiculo WHERE id_user = " + id;
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        System.out.println ("Consultando dados na tabela, aguarde!!");
        Statement statement = conexao.createStatement ();
        ResultSet result = statement.executeQuery (instrucaoSQL);

        while (result.next ()) {
            Veiculo veiculo = new Veiculo ();
            veiculo.setMarca (result.getString (1));
            veiculo.setModelo (result.getString (2));
            veiculo.setTipoMotor (result.getString (3));
            veiculo.setAno (result.getInt (4));
            veiculo.setPlaca(result.getString (5));
            v.add (veiculo);
        }
        return v;
    }

    public void getVeiculo(Veiculo veiculo) {
        String sql = "SELECT marca, modelo, motor, ano, id_veiculo FROM t_veiculo WHERE id_user = " + veiculo.getId ();
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();
        try {
            System.out.println ("Consultando dados na tabela, aguarde!!");
            Statement statement = conexao.createStatement ();
            ResultSet result = statement.executeQuery (sql);
            if (result.next ()) {
                System.out.println ("marca: " + result.getString (1));
                System.out.println ("modelo: " + result.getString (2));
                System.out.println ("motor: " + result.getString (3));
                System.out.println ("ano: " + result.getInt (4));
            }

            result.close ();
            statement.close ();
            conexao.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }
    }

    public void deletarVeiculo(int Id) {
        String sql = "DELETE FROM t_veiculo WHERE id_veiculo = " + Id;
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        try {
            Statement statement = conexao.createStatement ();
            statement.executeUpdate (sql);
            System.out.println ("Dados excluido com sucesso!");
            statement.close ();
            conexao.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }
    }

    //Histrorico

    public void addHistorico(Historico historico) {
        Date dataProblema = new Date (System.currentTimeMillis ());

        String sql = "INSERT INTO t_historico (peca,data_problema, descricao, id_veiculo)" +
                "VALUES (?, ?, ?, ?)";
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();
        try {
            PreparedStatement statement = conexao.prepareStatement (sql);
            statement.setString (1 , historico.getPeca ());
            statement.setDate (2 , dataProblema);
            historico.setDataProblema (dataProblema);
            statement.setString (3 , historico.getDescricao ());
            statement.setInt (4 , historico.getIdVeiculo ());
            statement.execute ();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                 historico.setId (generatedKeys.getInt (1));
            }

            System.out.println ("Dados inseridos com sucesso!");
            statement.close ();
            conexao.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }

    }

    public void listaProblema(int id) {
        String instrucaoSQL = "SELECT id_historico, peca, data_problema, descricao FROM t_historico WHERE id_veiculo = " + id;
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();
        Statement st = null;
        ResultSet result = null;
        try {
            System.out.println ("Consultando dados na tabela, aguarde!!");
            st = conexao.createStatement ();
            result = st.executeQuery (instrucaoSQL);
            while (result.next ()) {
                System.out.println ("ID: " + result.getString (1));
                System.out.println ("peca: " + result.getString (2));
                System.out.println ("data_problema: " + result.getString (3));
                System.out.println ("descricao: " + result.getString (4));
            }
            result.close ();
            st.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }
    }

    public void getProblema(int id) {
        String instrucaoSQL = "SELECT peca, data_problema, descricao FROM t_historico WHERE id_historico = " + id;
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();
        Statement st = null;
        ResultSet result = null;
        try {
            System.out.println ("Consultando dados na tabela, aguarde!!");
            st = conexao.createStatement ();
            result = st.executeQuery (instrucaoSQL);
            while (result.next ()) {
                System.out.println ("peca: " + result.getString (2));
                System.out.println ("data_problema: " + result.getString (3));
                System.out.println ("descricao: " + result.getString (4));
            }
            result.close ();
            st.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }
    }

    public void deletarHistorico(int id){
        String sql = "DELETE FROM t_historico WHERE id_historico = " + id;
        conexaoJDBC.conectar ();
        Connection conexao = conexaoJDBC.getConexao ();

        try {
            Statement statement = conexao.createStatement ();
            statement.executeUpdate (sql);
            System.out.println ("Dados excluido com sucesso!");
            statement.close ();
            conexao.close ();

        } catch (Exception e) {
            System.out.println ("Erro");
            e.printStackTrace ();
        }
    }

}
