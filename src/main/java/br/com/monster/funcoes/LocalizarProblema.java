package br.com.monster.funcoes;

import br.com.monster.model.veiculo.Veiculo;

import java.util.ArrayList;

public class LocalizarProblema {
    private Veiculo veiculo;
    private String problema;
    private ArrayList<String> relatorio;

    public LocalizarProblema(Veiculo veiculo, String problema, String relatorio1) {
        this.veiculo = veiculo;
        this.problema = problema;
        this.relatorio = new ArrayList<>();
        this.relatorio.add(relatorio1);
    }

    //Getters e Setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public ArrayList getRelatorio() {
        return relatorio;
    }
    public void addRelatorio(String problema1){
        relatorio.add(problema1);
    }
}
