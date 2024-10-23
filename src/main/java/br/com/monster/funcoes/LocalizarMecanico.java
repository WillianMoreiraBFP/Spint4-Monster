package br.com.monster.funcoes;

public class LocalizarMecanico {
    private String cep;
    private String cepMecanico;

    public LocalizarMecanico(String cep, String cepMecanico) {
        this.cep = cep;
        this.cepMecanico = cepMecanico;
    }


    //Gatters
    public String getCep() {
        return cep;
    }
    public String getCepMecanico() {
        return cepMecanico;
    }


    //Setters

    public void setCep(String cep) {
        if (validarCep(cep)){
            this.cep = cep;
        } else {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }
    public void setCepMecanico(String CEP) {
        if (validarCep(CEP)){
            this.cepMecanico = CEP;
        } else {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }


    // Método para validar o Cep
    private boolean validarCep(String cep){
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }

}
