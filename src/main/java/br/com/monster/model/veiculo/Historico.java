package br.com.monster.model.veiculo;

import java.util.Date;

public class Historico {
    private int idVeiculo;
    private int id;
    private String peca;
    private Date dataProblema;
    private String descricao;

    public Historico(String peca  , int id1, String descricao) {
        this.peca = peca;
        this.descricao = descricao;
        this.idVeiculo = id1;
    }

    //Getters e Setters

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public Date getDataProblema() {
        return dataProblema;
    }

    public void setDataProblema(Date dataProblema) {
        this.dataProblema = dataProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
