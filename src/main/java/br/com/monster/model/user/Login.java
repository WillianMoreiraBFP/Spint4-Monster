package br.com.monster.model.user;


import br.com.monster.DAO.DAO;

public class Login extends User {
    private int id;

    public Login() {
    }


    public Login(String senha, String email) {
        setSenha(senha);
        setEmail(email);
    }
    public Login(Cadastro cadastro) {
        setSenha(cadastro.getSenha ());
        setEmail(cadastro.getEmail ());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
