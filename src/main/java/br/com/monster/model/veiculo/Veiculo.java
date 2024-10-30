package br.com.monster.model.veiculo;

public class Veiculo {
    private String email;
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String tipoMotor;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(String marca , String modelo , int ano , String placa , String email) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.email = email;
    }

    public Veiculo(String marca , String modelo , int ano , String tipoMotor , String placa , String email) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.tipoMotor = tipoMotor;
        this.placa = placa;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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