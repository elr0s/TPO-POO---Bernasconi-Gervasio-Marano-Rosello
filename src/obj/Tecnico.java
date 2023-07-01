package obj;

import java.util.ArrayList;
import java.util.List;
public class Tecnico {
    
    private String nombre;
    private String tipoDoc;
    private String doc;
    private float salarioBase;
    private ArrayList<ManoDeObra> manosDeObra = new ArrayList<>();

    // Métodos setters
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

    public void setManosDeObras(ManoDeObra a){
        this.manosDeObra.add(a);
    }
    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public String getTipoDoc()
    {
        return tipoDoc;
    }

    public String getDoc() {
        return doc;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public boolean soyEseTecnico(String doc){
        return  this.doc == doc;
    }

    public float calcularSueldo(){
        float total = salarioBase;
        for (ManoDeObra a: manosDeObra) {
            ArrayList <ManoXReparacion> manosXReparaciones = a.getManosXReparaciones();
            for (ManoXReparacion e: manosXReparaciones) {
                total += e.obtenerDuracion() * a.obtenerValH();
            }
        }
        return total;
    }

}

