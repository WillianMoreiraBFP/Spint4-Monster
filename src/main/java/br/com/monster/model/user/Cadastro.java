package br.com.monster.model.user;


public class Cadastro extends User {

    public Cadastro() {
    }

    public Cadastro(String userName, String senha, String email) {
        setUserName (userName);
        setSenha(senha);
        setEmail(email);
    }

    public Cadastro(String userName, String senha, String telefone, String email, String cep) {
        setUserName(userName);
        setSenha(senha);
        setTelefone(telefone);
        setEmail(email);
        setCep(cep);

    }
}