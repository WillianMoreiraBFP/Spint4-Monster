package br.com.monster.model.veiculo;

import br.com.monster.model.user.Login;

public class Veiculo {
    private int idUser;
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String tipoMotor;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String marca , String modelo , int ano , String placa , int idUser) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.idUser = idUser;
    }

    public Veiculo(String marca , String modelo , int ano , String tipoMotor , String placa , int idUser) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoMotor = tipoMotor;
        this.placa = placa;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}