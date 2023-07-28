package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import exception.ClienteException;
import exception.ManoDeObraException;
import exception.ReparacionException;
import exception.RepuestoException;
import exception.TecnicoException;
import exception.VehiculoException;
import obj.Cliente;
import obj.ManoDeObra;
import obj.ManoXReparacion;
import obj.Reparacion;
import obj.Repuesto;
import obj.RepuestoXReparacion;
import obj.Tecnico;
import obj.Vehiculo;

public class Controlador {
    // Declaración de ArrayList de todas las clases
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
    ArrayList<ManoDeObra> manoDeObras = new ArrayList<ManoDeObra>();
    ArrayList<Repuesto> repuestos = new ArrayList<Repuesto>();
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    ArrayList<Reparacion> reparaciones = new ArrayList<Reparacion>();
    ArrayList<RepuestoXReparacion> repuestosXReparaciones = new ArrayList<RepuestoXReparacion>();
    ArrayList<ManoXReparacion> manoXReparaciones = new ArrayList<ManoXReparacion>();
    ArrayList<String> reparacionesRegistradas = new ArrayList<String>(); // Nuevo ArrayList para almacenar datos de reparaciones

    private static Controlador instancia;
    private int ultimoIdReparacion = 0; // Nuevo atributo para llevar el seguimiento del último ID de reparación

    private Controlador() {
        // cargar datos falsos
        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNombre("Juan");
        tecnico1.setTipoDoc("DNI");
        tecnico1.setDoc("12345678");
        tecnico1.setSalarioBase(5000.0f);
        tecnicos.add(tecnico1);
        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNombre("Maria");
        tecnico2.setTipoDoc("DNI");
        tecnico2.setDoc("87654321");
        tecnico2.setSalarioBase(5500.0f);
        tecnicos.add(tecnico2);
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Sebastian");
        cliente1.setTipoDoc("DNI");
        cliente1.setDoc("12356753");
        cliente1.setCtaCte(5000);
        cliente1.setLimiteCtaCte(50000);
        
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Mateo");
        cliente2.setTipoDoc("DNI");
        cliente2.setDoc("2345665");
        cliente2.setCtaCte(3000);
        cliente2.setLimiteCtaCte(40000);
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        //dejando Vehiculos registrados
        Vehiculo vehiculo1 = new Vehiculo();
        vehiculo1.registrarVehiculo("HGR 664","peugeot","308", 2019, cliente2);
        
        Vehiculo vehiculo2 = new Vehiculo();
        vehiculo2.registrarVehiculo("FMY 209", "Ford", "K", 2009, cliente1);
        
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        
        //dejando Reparacion registrada
        
        Reparacion reparacion = new Reparacion();
        reparacion.setReparacion(999,LocalDate.now(), vehiculo1,cliente1);
        reparaciones.add(reparacion);
        
        //dejando Repuestos registrados
        Repuesto repuesto1 = new Repuesto();
        repuesto1.setCodigo(1);
        repuesto1.setDescripcion("Tornillo nro 6");
        repuesto1.setPrecio(10);
        
        Repuesto repuesto2 = new Repuesto();
        repuesto2.setCodigo(2);
        repuesto2.setDescripcion("Filtro de nafta");
        repuesto2.setPrecio(300);
        
        Repuesto repuesto3 = new Repuesto();
        repuesto3.setCodigo(3);
        repuesto3.setDescripcion("liquido de frenos");
        repuesto3.setPrecio(200);
        
        Repuesto repuesto4 = new Repuesto();
        repuesto4.setCodigo(4);
        repuesto4.setDescripcion("Correa de distribucion");
        repuesto4.setPrecio(600);
        
        Repuesto repuesto5 = new Repuesto();
        repuesto5 = new Repuesto();
        repuesto5.setCodigo(5);
        repuesto5.setDescripcion("Bujias de encendido");
        repuesto5.setPrecio(700);
        
        repuestos.add(repuesto1);
        repuestos.add(repuesto2);
        repuestos.add(repuesto3);
        repuestos.add(repuesto4);
        repuestos.add(repuesto5);
        
        //dejando manos de obra registradas
        ManoDeObra mano1 = new ManoDeObra();
        mano1.registrarManoDeObra(1, "cambiar la bujia de encendido", tecnico2, 50);
        
        ManoDeObra mano2 = new ManoDeObra();
        mano2.registrarManoDeObra(2, "cambiar correa de distribucion", tecnico1, 100);
        
        ManoDeObra mano3 = new ManoDeObra();
        mano3.registrarManoDeObra(3, "cambiar filtro de nafta", tecnico2, 30);
        
        ManoDeObra mano4 = new ManoDeObra();
        mano4.registrarManoDeObra(4, "cambiar liquido de freno", tecnico1, 25);
        
        manoDeObras.add(mano1);
        manoDeObras.add(mano2);
        manoDeObras.add(mano3);
        manoDeObras.add(mano4);
        
        //dejando manoXreparacion registradas
        ManoXReparacion manoXr = new ManoXReparacion();
        manoXr.setManoXReparacion(mano1,reparacion,20);
        //esto afecta el calculo del sueldo del tecnico2. Se va a tener en cuenta para el calculo del sueldo
        
        //dejando respuestoXreparacion registrado
        RepuestoXReparacion repXrep = new RepuestoXReparacion();
        repXrep.setRepuestoXReparacion(repuesto5, reparacion, 1);
        repuestosXReparaciones.add(repXrep);
    }

    public static Controlador getInstancia() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }

    public int nuevaReparacion(String doc, String patente) throws ClienteException, VehiculoException {
        Cliente cliente = buscarCliente(doc);
        Vehiculo vehiculo = buscarVehiculo(patente);
        if (cliente == null) {
            throw new ClienteException("Debe registrar al cliente");
        } else if (vehiculo == null) {
            throw new VehiculoException("Debe registrar al vehiculo");
        }
        ultimoIdReparacion++; // Incrementar el último ID de reparación
        Reparacion rep = new Reparacion();
        rep.setReparacion(ultimoIdReparacion, LocalDate.now(), vehiculo, cliente); // Generar nuevo ID de reparación
        reparaciones.add(rep);
        
        reparacionesRegistradas.add("ID: " + rep.getId() + ", Cliente: " + cliente.getNombre() + ", Vehiculo: " + vehiculo.getPatente()); // Guardar datos de la reparación registrada
        return rep.getId();
    }


    public boolean clienteRegistrado(String doc) {
        try {
            Cliente c = buscarCliente(doc);
            return c != null;
        } catch (ClienteException e) {
            return false;
        }
    }
    
    public boolean vehiculoRegistrado(String patente) throws VehiculoException{
        Vehiculo v = buscarVehiculo(patente);
        if(v != null){
            return true;
        }else {
            return false;
        }
    }

    public void registrarCliente(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte) throws ClienteException{
	   	Cliente c = new Cliente();
	    c.registrarCliente(nombre, tipoDoc, doc, ctaCte, limiteCtaCte);
	    clientes.add(c);
        
    }

    public void registrarVehiculo(String patente, String marca, String modelo, int año, String docDueño) throws ClienteException {
        Vehiculo v = new Vehiculo();
        Cliente dueño = buscarCliente(docDueño);
        v.registrarVehiculo(patente, marca, modelo, año, dueño);
        vehiculos.add(v);
    }
    
    public void terminarReparacion(int idRep) throws ReparacionException {
        Reparacion rep = buscarReparacion(idRep);
        if (rep != null) {
            rep.actualizarEstado("Terminada");
        } else {
            throw new ReparacionException("La reparacion con el id " + idRep + " no se encuentra registrada");
        }
    }
    
    
    public float retirarVehiculo(Reparacion rep)throws ReparacionException,ClienteException {
        if(rep.estoyTerminada()) {
            float total = 0;

            ArrayList<RepuestoXReparacion> repuestosXReparaciones = rep.getRespuestosReparacion();
            ArrayList<ManoXReparacion> manoXReparaciones = rep.getManoXReparaciones();


            for(RepuestoXReparacion r:repuestosXReparaciones)
                total +=r.subTotalRep();

            for(ManoXReparacion m:manoXReparaciones)
                total +=m.obtenerDuracion();

            String docCliente = rep.getCliente().getDoc();

            agregarACtaCte(docCliente,total);

            rep.actualizarEstado("Retirada");

            return total;
        }else {
            throw new ReparacionException("La reparacion no esta terminada");
        }
    }
    public boolean mePasoEnDeuda(String doc, float precio) throws ClienteException {
        Cliente c = buscarCliente(doc);
        if (c != null) {
            return c.mePasoEnDeuda(precio);
        } else {
            throw new ClienteException("El cliente con el documento " + doc + " no está registrado");
        }
    }

    public void agregarACtaCte(String doc, float precio) throws ClienteException {
        Cliente c = buscarCliente(doc);
        if (c != null && !mePasoEnDeuda(doc, precio)) {
            c.actualizarCta(precio);
        }
    }

    public void agregarRepuesto(int codigoReparacion, int idRepuesto, int cantidad) throws ReparacionException, RepuestoException {
        Reparacion reparacion = buscarReparacion(codigoReparacion);
        Repuesto   repuesto   = buscarRepuesto(idRepuesto);
        if (reparacion != null) {
            if (repuesto != null) {
                reparacion.agregarRepuesto(repuesto, cantidad);
            } else {
                throw new RepuestoException("El repuesto no está registrado");
            }
        } else {
            throw new ReparacionException("La reparación con el código " + codigoReparacion + " no está registrada");
        }
    }

    public void agregarManoDeObra(int codigoReparacion, int codigoManoDeObra, float duracion) throws ReparacionException, ManoDeObraException {
        Reparacion reparacion = buscarReparacion(codigoReparacion);
        ManoDeObra manoDeObra = buscarManoDeObra(codigoManoDeObra);
        if (reparacion != null ) {
            if (manoDeObra != null) {
                reparacion.agregarManoDeObra(manoDeObra, duracion);
            } else {
                throw new ManoDeObraException("La mano de obra no está registrada");
            }
        } else {
            throw new ReparacionException("La reparación con el código " + codigoReparacion + " no está registrada");
        }
    }

    public void agregarTecnico(String nombre, String tipoDoc, String doc, float salarioBase) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setTipoDoc(tipoDoc);
        tecnico.setDoc(doc);
        tecnico.setSalarioBase(salarioBase);
        tecnicos.add(tecnico);
    }

    public Reparacion buscarReparacion(int codigo) throws ReparacionException {
        for (Reparacion r : reparaciones) {
            if (r.soyEsaReparacion(codigo)) {
                return r;
            }
        }
        throw new ReparacionException("La reparación con el código " + codigo + " no está registrada");
    }



    public Cliente buscarCliente(String doc) throws ClienteException {
        for (Cliente c : clientes) {
            if (c.soyEseCliente(doc)) {
                return c;
            }
        }
        throw new ClienteException("El cliente con el documento " + doc + " no está registrado");
    }

    private Vehiculo buscarVehiculo(String patente) throws VehiculoException {
        for (Vehiculo v : vehiculos) {
            if (v.soyEseVehiculo(patente)) {
                return v;
            }
        }
        throw new VehiculoException("El vehiculo con patente " + patente + " no está registrado");
    }

    private Tecnico buscarTecnico(String doc) throws TecnicoException {
        for (Tecnico t : tecnicos) {
            if (t.soyEseTecnico(doc)) {
                return t;
            }
        }
        throw new TecnicoException("El técnico con el documento " + doc + " no está registrado");
    }

    private Repuesto buscarRepuesto(int codigo) throws RepuestoException {
        for (Repuesto r : repuestos) {
            if (r.soyEseRepuesto(codigo)) {
                return r;
            }
        }
        throw new RepuestoException("El repuesto con el código " + codigo + " no está registrado");
    }

    private ManoDeObra buscarManoDeObra(int codigo) throws ManoDeObraException {
        for (ManoDeObra m : manoDeObras) {
            if (m.soyEsaManoDeObra(codigo)) {
                return m;
            }
        }
        throw new ManoDeObraException("La mano de obra con el código " + codigo + " no está registrada");
    }
    
    public double calcularSueldo(String doc) throws TecnicoException {

        Tecnico tecnico = buscarTecnico(doc);
        if (tecnico != null) {
            return tecnico.calcularSueldo();
        } else {
            throw new TecnicoException("El técnico con el documento " + doc + " no está registrado");
        }
    }
}