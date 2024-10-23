package br.com.monster.Service;

import br.com.monster.DAO.DAO;
import br.com.monster.model.user.Cadastro;
import br.com.monster.model.user.Login;

import java.sql.SQLException;

public class UserService {
    DAO d = new DAO();

    public Login cadastro(Cadastro cadastro) throws SQLException {

        Login login = new Login(cadastro.getEmail(), cadastro.getSenha());

        d.cadastro(cadastro);
        d.login(login);

        return login;

    }

    public Login login (String email, String senha) throws SQLException{
        Login login = new Login(email,senha);

        d.login(login);

        return login;
    }

    public void update (int id, String nome, String cep, String telefone, String email, String senha) throws SQLException{

        d.updateNome(id,nome);
        d.updatetCep(id, cep);
        if (validarTelefone(telefone)){
            String t = formatTelefone(telefone);
            d.updateTel(id, t);
        }
        d.updatetEmail(id, email);
        d.updateSenha(id, senha);

    }

    public void delete (int id) throws SQLException{
        d.deleteUser(id);
    }


    // Método para validar o número de telefone
    private boolean validarTelefone(String telefone1) {
        return telefone1 != null && telefone1.matches ("\\d{10,11}");
    }

    //Metodo para formatar o número de telefone (exemplo: (99) 99999-9999)
    private String formatTelefone(String telfone1) {
        if (telfone1.length () == 10) {
            return String.format ("(%s) %s-%s" ,
                    telfone1.substring (0 , 2) ,
                    telfone1.substring (2 , 6) ,
                    telfone1.substring (6)
            );
        } else if (telfone1.length () == 11) {
            return String.format ("(%s) %s-%s" ,
                    telfone1.substring (0 , 2) ,
                    telfone1.substring (2 , 7) ,
                    telfone1.substring (7)
            );
        }
        return telfone1;
    }

}
