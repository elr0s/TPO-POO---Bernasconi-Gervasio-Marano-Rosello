package view;

import obj.Cliente;

public class VehiculoView {
    private String patente;
    private String marca;
    private String modelo;
    private int año;
    private Cliente dueño;

    public VehiculoView(){}

    public VehiculoView(String patente, String marca, String modelo, int año, Cliente dueño){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.dueño = dueño;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public String getPatente() {
        return patente;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public Cliente getDueño() {
        return dueño;
    }
}
