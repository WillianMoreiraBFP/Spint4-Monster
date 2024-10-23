package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import java.sql.SQLException;

public class UserService {
    DAO d = new DAO();

    public Login cadastro(Cadastro cadastro) throws SQLException {

        Login login = new Login(cadastro.getSenha(),cadastro.getEmail());

        //d.cadastro(cadastro);
        d.login(login);

        return login;

    }

    public Login login (String email, String senha) throws SQLException{
        Login login = new Login(senha,email);

        d.login(login);

        return login;
    }

    public void update (int id, String nome, String cep, String telefone, String email, String senha) throws SQLException{

        d.updateNome(id,nome);
        d.updatetCep(id, cep);
        d.updateTel(id, telefone);
        d.updatetEmail(id, email);
        d.updateSenha(id, senha);

    }

    public void delete (int id) throws SQLException{
        d.deleteUser(id);
    }

}
