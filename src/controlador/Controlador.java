package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import exception.*;
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

    private static Controlador instancia;
    private Controlador(){
        //cargar datos falsos?
    }
    public static Controlador getInstancia(){
        if(instancia == null){
            instancia = new Controlador();
        }
        return instancia;
    }
    public int nuevaReparacion(String doc, String patente) throws ClienteException, VehiculoException{
        Cliente cliente = buscarCliente(doc);
        Vehiculo vehiculo = buscarVehiculo(patente);
        if (cliente == null){
            //msj de que debe registrar al cliente y
            // un cartel que diga registrar cliente
        } else if (vehiculo == null) {
            //msj de que debe registrar al vehiculo y
            // un cartel que diga registrar vehiculo
        }
        Reparacion rep = new Reparacion();
        rep.setRepacion(0, LocalDate.now(),vehiculo,cliente);
        //ver como hacer para que cree a reparacion y parametros etc
        return rep.getId();
    }

    public boolean vehiculoRegistrado(String patente) throws VehiculoException{
        Vehiculo v = buscarVehiculo(patente);
        if(v != null){
            return true;
        }else {
            return false;
        }
    }

    public boolean clienteRegistrado(String doc) throws ClienteException{
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

    public  void actualizarEstado(int idRep,String estado) throws ReparacionException{
        //para pasarlo de pendiente a en proceso
        Reparacion rep = buscarReparacion(idRep);
        if (rep != null){
            rep.actualizarEstado(estado);
        }
    }
    public void terminarReparacion(int idRep) throws ReparacionException{
        //para pasarlo de en proceso a terminada
        Reparacion rep = buscarReparacion(idRep);
        if (rep != null){
            rep.actualizarEstado("Terminada");
        }
    }

    public void retirarVehiculo(Reparacion rep){
        //aca se actualiza el estado de terminada a retirada

    }

    public boolean mePasoEnDeuda(String doc, float precio) throws ClienteException{
        Cliente c = buscarCliente(doc);
        if(c != null){
            c.mePasoEnDeuda(precio);
        }else {
            return true; //Sacar y agregar excepcion por si no lo encuentra
        }
        return false; //Sacar y agregar excepcion por si no lo encuentra
    }

    public void agregarACtaCte(String doc, float precio) throws ClienteException{
        Cliente c = buscarCliente(doc);
        if(c != null && !mePasoEnDeuda(doc,precio)){
            c.actualizarCta(precio);
        }
    }

    /*
    public float calcularSueldo(String doc){

    }

     */

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

    private Reparacion buscarReparacion(int codigo) throws ReparacionException{
        for (Reparacion r : reparaciones) {
            if (r.soyEsaReparacion(codigo)) {
                return r;
            }
        }
        throw new ReparacionException("La reparacion con el id "+codigo+" no se encuentra registada");
    }

    private Cliente buscarCliente(String doc) throws ClienteException {
        for (Cliente c: clientes) {
            if(c.soyEseCleinte(doc)) {
                return c;
            }else{
                return null;
            }
        }
        throw new ClienteException("El cliente con el documento " + doc + "no esta registrado");
    }

    private Vehiculo buscarVehiculo(String patente) throws VehiculoException {
            for (Vehiculo v: vehiculos) {
                if(v.soyEseVehiculo(patente)){
                    return v;
                }else
                    return null;
            }
            throw new VehiculoException("El vehiculo con patente " + patente + "No esta regisrtrado");
    }

    private Tecnico buscarTecnico(String doc) throws TecnicoException {
        for (Tecnico t :
                tecnicos) {
            if (t.soyEseTecnico(doc)){
                return t;
            }
        }
        throw new TecnicoException("El tecnico con el documento " + doc + "no esta registrado");
    }

    private Repuesto buscarRepuesto(int codigo) throws RepuestoException {
        for (Repuesto r: repuestos) {
            if (r.soyEseRepuesto(codigo)){
                return r;
            }
        }
        throw new RepuestoException("El repuesto con el id "+ codigo + "no esta registrado");
    }

    private ManoDeObra buscarManoDeObra(int codigo) throws ManoDeObraException {
        for (ManoDeObra m:manoDeObras) {
            if (m.soyEsaManoDeObra(codigo)){
                return m;
            }
        }
        throw new ManoDeObraException("La mano de obra "+codigo+ " no se encuentra registrada");
    }



}
