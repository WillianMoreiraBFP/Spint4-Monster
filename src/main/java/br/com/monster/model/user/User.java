package br.com.monster.model.user;

public abstract class User {
    protected String userName;
    protected String senha;
    private String telefone;
    private String email;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}

/*

    //Telefone

    // Método para validar o número de telefone
    protected boolean validarTelefone(String telefone1) {
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
*/