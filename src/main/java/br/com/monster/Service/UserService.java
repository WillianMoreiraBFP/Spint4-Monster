package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import java.sql.SQLException;

public class UserService {
    DAO d = new DAO();

    public Login cadastroService (Cadastro cadastro) throws SQLException {

        Login login = new Login(cadastro.getSenha(),cadastro.getEmail());

        d.cadastro(cadastro);
        d.login(login);

        return login;

    }


    public Login loginService (Login user) throws SQLException{
        Login login = new Login(user.getSenha (),user.getEmail ());

        d.login(login);

        return login;
    }

    public Login getService (String email) throws SQLException{
        return d.getDados(email);
    }

    public void updateService(Login login) throws SQLException{

        d.updateNome(login.getEmail (), login.getUserName ());
        d.updatetCep(login.getEmail (), login.getCep ());
        d.updateTel(login.getEmail (), login.getTelefone ());
        d.updatetEmail(login.getEmail (), login.getEmail ());
        d.updateSenha(login.getEmail (), login.getSenha ());

    }

    public void deleteService (String email) throws SQLException{
        d.deleteUser(email);
    }

}
