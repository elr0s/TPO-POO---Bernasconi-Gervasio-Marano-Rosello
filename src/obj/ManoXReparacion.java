package obj;

import java.time.LocalDate;

public class ManoXReparacion {
    private ManoDeObra manoDeObra;
    private Reparacion reparacion;
    private float duracion;

    public Reparacion getReparacion() {
        return this.reparacion;
    }

    public float obtenerDuracion() {
        return duracion;
    }

    public void setManoXReparacion(ManoDeObra manoDeObra, Reparacion reparacion, float duracion) {
        this.manoDeObra = manoDeObra;
        this.reparacion = reparacion;
        this.duracion = duracion;
        manoDeObra.setManosXReparaciones(this);
    }

    
}
