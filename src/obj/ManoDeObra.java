package obj;

public class ManoDeObra {

    private int codigo;
    private String descripcion;
    private Tecnico tecnico;
    private float valorHora;

    public boolean soyEsaManoDeObra(int codigo){
        return this.codigo == codigo;
    }

    public void registrarManoDeObra(int codigo, String desc, Tecnico t, float valH){
        this.codigo = codigo;
        this.descripcion = desc;
        this.tecnico = t;
        this.valorHora = valH;
    }

    public float obtenerValH(){
        return this.valorHora;
    }

    public int getCodigo(){
        return this.codigo;
    }
}