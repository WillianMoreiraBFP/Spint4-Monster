package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import java.sql.SQLException;

public class UserService {
    DAO d = new DAO();

    public Login cadastroService (Cadastro cadastro) throws SQLException {

        Login login = new Login(cadastro.getSenha(),cadastro.getEmail());

        //d.cadastro(cadastro);
        d.login(login);

        return login;

    }

    public Login loginService (Login user) throws SQLException{
        Login login = new Login(user.getSenha (),user.getEmail ());

        d.login(login);

        return login;
    }

    public void updateService(Login login) throws SQLException{

        d.updateNome(login.getId (), login.getUserName ());
        d.updatetCep(login.getId (), login.getCep ());
        d.updateTel(login.getId (), login.getTelefone ());
        d.updatetEmail(login.getId (), login.getEmail ());
        d.updateSenha(login.getId (), login.getSenha ());

    }

    public void deleteService (int id) throws SQLException{
        d.deleteUser(id);
    }

}
