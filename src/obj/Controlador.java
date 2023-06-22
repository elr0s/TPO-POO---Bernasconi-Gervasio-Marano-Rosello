package obj;

public class Controlador {
    public int nuevaReparacion(Cliente cliente, Vehiculo vehiculo){

    }

    public boolean vehiculoRegistrado(String patente){

    }

    public boolean clienteRegistrado(String doc){

    }

    public void registrarCliente(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte){

    }

    public void registrarVehiculo(String patente, String marca, String modelo, int año, Cliente dueño){

    }

    public void terminarReparacion(int codigo, String estado){

    }

    public boolean mePasoEnDeuda(String doc, float precio){

    }

    public void agregarACtaCte(String doc, float precio){

    }

    public float calcularSueldo(String doc){

    }

    public void agregarRepuesto(int codigoReparacion, Repuesto repuesto, int cantidad){

    }

    public void agregarManoDeObra(int reparacion, int manoDeObra){

    }

    private Reparacion buscarReparacion(int codigo){

    }

    private Cliente buscarCliente(String doc){

    }

    private Vehiculo buscarVehiculo(String patente){

    }

    private Tecnico buscarTecnico(String doc){

    }

    private Repuesto buscarRepuesto(int codigo){

    }

    private ManoDeObra buscarManoDeObra(int codigo){

    }
}
