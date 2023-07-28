package view;

import obj.ManoXReparacion;
import obj.Tecnico;

import java.util.ArrayList;

public class ManoDeObraView {
    private int codigo;
    private String descripcion;
    private Tecnico tecnico;
    private float valorHora;
    private ArrayList<ManoXReparacion> manosXReparaciones = new ArrayList<>();

    public ManoDeObraView(){

    }
    public ManoDeObraView(int codigo, String descripcion, Tecnico tecnico, float valorHora,
                          ArrayList<ManoXReparacion> manosXReparaciones){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tecnico = tecnico;
        this.valorHora = valorHora;
        this.manosXReparaciones = manosXReparaciones;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public void setManosXReparaciones(ArrayList<ManoXReparacion> manosXReparaciones) {
        this.manosXReparaciones = manosXReparaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public float getValorHora() {
        return valorHora;
    }

    public ArrayList<ManoXReparacion> getManosXReparaciones() {
        return manosXReparaciones;
    }
}
