package br.com.monster.funcoes;

public class Orcamento {
    private String problema;
    private String pecaComProblema;
    private Double precoPeca;
    private Double maoDeObra;

    public Orcamento(String problema, String pecaComProblema, Double precoPeca, Double maoDeObra) {
        this.problema = problema;
        this.pecaComProblema = pecaComProblema;
        this.precoPeca = precoPeca;
        this.maoDeObra = maoDeObra;
    }

    //Getters e Setters


    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getPecaComProblema() {
        return pecaComProblema;
    }

    public void setPecaComProblema(String pecaComProblema) {
        this.pecaComProblema = pecaComProblema;
    }

    public Double getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(Double precoPeca) {
        this.precoPeca = precoPeca;
    }

    public Double getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(Double maoDeObra) {
        this.maoDeObra = maoDeObra;
    }
}
