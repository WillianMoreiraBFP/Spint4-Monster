package br.com.monster.model.user;


public class Cadastro extends User {

    public Cadastro(String userName, String senha, String email) {
        setUserName (userName);
        setSenha(senha);
        setEmail(email);
    }

    public Cadastro(String userName, String senha, String telefone, String email, String uf, String localidade, String bairro, String logradouro) {
        setUserName(userName);
        setSenha(senha);
        setTelefone(telefone);
        setEmail(email);
        setLogradouro (logradouro);
        setBairro (bairro);
        setLocalidade (localidade);
        setUf (uf);
    }
}