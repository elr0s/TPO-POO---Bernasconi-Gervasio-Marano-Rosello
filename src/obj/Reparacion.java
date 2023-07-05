package obj;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reparacion {
    private int id;
    private LocalDate fechaIngreso;
    private Vehiculo vehiculoAReparar;
    private Cliente cliente;
    private String estado;
    private ArrayList <RepuestoXReparacion> respuestosReparacion = new ArrayList();
    private ArrayList <ManoXReparacion>     manoXReparaciones    = new ArrayList<>();

    public boolean soyEsaReparacion(int id)
    {
        return this.id==id;

    }
    public void terminarReparacion(){

        actualizarEstado("Terminadas");
    }

    public void setRepacion( int id, LocalDate fechaIngreso, Vehiculo vehiculoAReparar, Cliente cliente){
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.vehiculoAReparar = vehiculoAReparar;
        this.cliente = cliente;
        this.estado = "Pendiente";
    }
    public void agregarRepuesto(Repuesto repuesto, int cantidad){
        if(!estoyTerminada()){
            RepuestoXReparacion nuevoRepuesto = new RepuestoXReparacion();
            nuevoRepuesto.setRepuestoXReparacion(repuesto,this,cantidad);
            respuestosReparacion.add(nuevoRepuesto);
        }

    }
    public void agregarManoDeObra(ManoDeObra manoDeObra, float duracion){
        if(!estoyTerminada()){
            if(this.estado!="En_Proceso")
                actualizarEstado("En_Proceso");
            ManoXReparacion a  = new ManoXReparacion();
            a.setManoXReparacion(manoDeObra,this,duracion);
            manoXReparaciones.add(a);
        }
    }
    public void actualizarEstado(String estado){
        this.estado = estado;
    }
    public float obtenerTotal(){
        float  total = 0;
        for (RepuestoXReparacion r : respuestosReparacion)
            total += r.subTotalRep ();
        return total;
    }
    public boolean estoyTerminada(){
        return this.estado=="Terminada";
    }

    public int getId(){
        return this.id;
    }
    public LocalDate getFechaIngreso(){
        return this.fechaIngreso;
    }
}
