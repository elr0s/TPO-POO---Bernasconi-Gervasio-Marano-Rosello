package obj;

public class Repuesto {

    private int codigo;
    private String descripcion;
    private float precio;

    public void setCodigo(int codigo) {
    	this.codigo = codigo;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
    
    public void setPrecio(float precio) {
    	this.precio = precio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public boolean soyEseRepuesto(int codigo) {
        return this.codigo == codigo;
    }

    public float obtenerPrecio() {
        return this.precio;
    }

    public int getCodigo() {
        return this.codigo;
    }
}