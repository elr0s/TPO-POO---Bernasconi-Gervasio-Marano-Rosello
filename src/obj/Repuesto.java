package obj;

public class Repuesto {

    private int codigo;
    private String descripcion;
    private float precio;

    public boolean soyEseRepuesto(int codigo){
        return this.codigo==codigo;
    }

    public float obtenerPrecio(){
        return this.precio;
    }

    public int getCodigo(Repuesto r){
        return this.codigo;
    }
}
