package view;

import obj.ManoDeObra;
import obj.Tecnico;

import java.util.ArrayList;

public class TecnicoView {
    private String nombre;
    private String tipoDoc;
    private String doc;
    private float salarioBase;
    private ArrayList<ManoDeObra> manosDeObra = new ArrayList<>();

    public TecnicoView(){
    }
    public TecnicoView(String nombre, String tipoDoc, String doc, float salarioBase,
                       ArrayList<ManoDeObra> manosDeObra){
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.salarioBase = salarioBase;
        this.manosDeObra = manosDeObra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setManosDeObra(ArrayList<ManoDeObra> manosDeObra) {
        this.manosDeObra = manosDeObra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getDoc() {
        return doc;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public ArrayList<ManoDeObra> getManosDeObra() {
        return manosDeObra;
    }
}
