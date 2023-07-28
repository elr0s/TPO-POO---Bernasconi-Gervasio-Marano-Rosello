package obj;

public class RepuestoXReparacion {
    private Repuesto repuesto;
    private Reparacion reparacion;
    private int cantidad;

    public float subTotalRep() {
        return cantidad * repuesto.obtenerPrecio();
    }

    public void setRepuestoXReparacion(Repuesto repuesto, Reparacion reparacion, int cantidad) {
        this.repuesto = repuesto;
        this.reparacion = reparacion;
        this.cantidad = cantidad;
    }

   
}
