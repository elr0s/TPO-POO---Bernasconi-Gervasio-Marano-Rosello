package view;

import java.security.AlgorithmConstraints;

public class RepuestoView {
    private int codigo;
    private String descripcion;
    private float precio;

    public RepuestoView(){

    }
    public RepuestoView(int codigo, String descripcion, float precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }
}
