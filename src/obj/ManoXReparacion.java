package obj;

public class ManoXReparacion {
    private ManoDeObra manoDeObra;
    private Reparacion reparacion;
    private float duracion;
    public float obtenerDuracion(){
        return  manoDeObra.obtenerValH()*duracion;
    }
    public void setManoXReparacion(ManoDeObra manoDeObra, Reparacion reparacion, float duracion){
        this.manoDeObra = manoDeObra;
        this.reparacion = reparacion;
    }
}
