package view;

import obj.Cliente;
import obj.ManoXReparacion;
import obj.RepuestoXReparacion;
import obj.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReparacionView {
    private int id;
    private LocalDate fechaIngreso;
    private Vehiculo vehiculoAReparar;
    private Cliente cliente;
    private String estado;
    private ArrayList<RepuestoXReparacion> respuestosReparacion = new ArrayList();
    private ArrayList <ManoXReparacion>     manoXReparaciones    = new ArrayList<>();

    public ReparacionView(){}
    public ReparacionView(int id,LocalDate fechaIngreso,Vehiculo vehiculoAReparar,Cliente cliente, String estado,
                          ArrayList<RepuestoXReparacion> respuestosReparacion,
                          ArrayList<ManoXReparacion> manoXReparaciones){
        this.id = id;
        this.fechaIngreso = fechaIngreso;
        this.vehiculoAReparar = vehiculoAReparar;
        this.cliente = cliente;
        this.estado = estado;
        this.respuestosReparacion = respuestosReparacion;
        this.manoXReparaciones = manoXReparaciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setVehiculoAReparar(Vehiculo vehiculoAReparar) {
        this.vehiculoAReparar = vehiculoAReparar;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRespuestosReparacion(ArrayList<RepuestoXReparacion> respuestosReparacion) {
        this.respuestosReparacion = respuestosReparacion;
    }

    public void setManoXReparaciones(ArrayList<ManoXReparacion> manoXReparaciones) {
        this.manoXReparaciones = manoXReparaciones;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Vehiculo getVehiculoAReparar() {
        return vehiculoAReparar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<RepuestoXReparacion> getRespuestosReparacion() {
        return respuestosReparacion;
    }

    public ArrayList<ManoXReparacion> getManoXReparaciones() {
        return manoXReparaciones;
    }
}
