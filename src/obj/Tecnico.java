package obj;

import java.time.LocalDate;
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

    public double calcularSueldo(int mes){
        double total;
        double totalManoDeObra = 0;
        for (ManoDeObra a: manosDeObra) {
            ArrayList <ManoXReparacion> manosXReparaciones = a.getManosXReparaciones();
            for (ManoXReparacion e: manosXReparaciones) {
                Reparacion rep = e.getReparacion();
                if(rep.estoyTerminada() && rep.getFechaIngreso().getMonthValue()==mes)
                    totalManoDeObra += e.obtenerDuracion() * a.obtenerValH();
            }
        }
        total = getSalarioBase() + (totalManoDeObra * 0.10);
        return total;
    }

}

