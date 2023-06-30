package controlador;

import java.util.ArrayList;

import obj.*;

public class Controlador {
    //Declarion de ArrayList de todas las clases
    ArrayList <Cliente> clientes = new ArrayList<Cliente>();
    ArrayList <Tecnico> tecnicos = new ArrayList<Tecnico>();
    ArrayList <ManoDeObra> manoDeObras = new ArrayList<ManoDeObra>();
    ArrayList <Repuesto> repuestos = new ArrayList<Repuesto>();
    ArrayList <Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    ArrayList <Reparacion> reparaciones = new ArrayList<Reparacion>();
    ArrayList <RepuestoXReparacion> repuestosXReparaciones = new ArrayList<RepuestoXReparacion>();
    ArrayList <ManoXReparacion> manoXReparaciones = new ArrayList<ManoXReparacion>();

    public int nuevaReparacion(Cliente cliente, Vehiculo vehiculo){

    }

    public boolean vehiculoRegistrado(String patente){
        Vehiculo v = buscarVehiculo(patente);
        if(v != null){
            return true;
        }else {
            return false;
        }
    }

    public boolean clienteRegistrado(String doc){
        Cliente c = buscarCliente(doc);
        if(c != null){
            return true;
        }else {
            return  false;
        }

    }

    public void registrarCliente(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte){
        Cliente c = new Cliente();
        c.registrarCliente(nombre,tipoDoc,doc,ctaCte,limiteCtaCte);
        clientes.add(c);
    }

    public void registrarVehiculo(String patente, String marca, String modelo, int año, Cliente dueño){
        //revisar metodo, como le paso el obj cliente
        Vehiculo v = new Vehiculo();
        v.registrarVehiculo(patente,marca,modelo,año, dueño);
        vehiculos.add(v);
    }

    public void terminarReparacion(int codigo, String estado){

    }

    public boolean mePasoEnDeuda(String doc, float precio){
        Cliente c = buscarCliente(doc);
        if(c != null){
            c.mePasoEnDeuda(precio);
        }else {
            return true; //Sacar y agregar excepcion por si no lo encuentra
        }
        return false; //Sacar y agregar excepcion por si no lo encuentra
    }

    public void agregarACtaCte(String doc, float precio){

    }

    public float calcularSueldo(String doc){

    }

    public void agregarRepuesto(int codigoReparacion, Repuesto repuesto, int cantidad){

        repuesto.soyEseRepuesto(repuesto.getCodigo(repuesto));
        if(repuesto != null){
            //codigo para agregar la mano a la reparacion
        }
    }

    public void agregarManoDeObra(Reparacion r, ManoDeObra m){
        r.soyEsaReparacion(r.getId());

        m.soyEsaManoDeObra((m.getCodigo()));
        if(m != null){
            //codigo para agregar la mano a la reparacion
        }

    }

    private Reparacion buscarReparacion(int codigo){
        for (Reparacion r : reparaciones) {
            if (r.soyEsaReparacion(codigo)) {
                return r;
            }
        }
        return  null; //sacar con excepcion
    }

    private Cliente buscarCliente(String doc){
        for (Cliente c: clientes) {
            if(c.soyEseCleinte(doc)) {
                return c;
            }
        }//sacar y agregar excepcion de que si no lo encuentra msj
        return null;
    }

    private Vehiculo buscarVehiculo(String patente){
            for (Vehiculo v: vehiculos) {
                if(v.soyEseVehiculo(patente)){
                    return v;
                }
            }//sacar y agregar excepcion de que si no lo encuentra msj
            return null;
    }

    private Tecnico buscarTecnico(String doc){
        for (Tecnico t :
                tecnicos) {
            if (t.soyEseTecnico(doc)){
                return t;
            }
        }//sacar y agregar excepcion de que si no lo encuentra msj
        return null;
    }

    private Repuesto buscarRepuesto(int codigo){
        for (Repuesto r: repuestos) {
            if (r.soyEseRepuesto(codigo)){
                return r;
            }
        }//sacar y agregar excepcion de que si no lo encuentra msj
        return null;
    }

    private ManoDeObra buscarManoDeObra(int codigo){
        for (ManoDeObra m:manoDeObras) {
            if (m.soyEsaManoDeObra(codigo)){
                return m;
            }
        }//sacar y agregar excepcion de que si no lo encuentra msj
        return null;
    }


}
