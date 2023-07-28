package obj;

import java.util.ArrayList;

public class ManoDeObra {

    private int codigo;
    private String descripcion;
    private Tecnico tecnico;
    private float valorHora;
    private ArrayList<ManoXReparacion> manosXReparaciones = new ArrayList<>();

    public float obtenerValH() {
        return this.valorHora;
    }

    
    public boolean soyEsaManoDeObra(int codigo){
        return this.codigo == codigo;
    }

    public void registrarManoDeObra(int codigo, String desc, Tecnico t, float valH){
        this.codigo = codigo;
        this.descripcion = desc;
        this.tecnico = t;
        this.valorHora = valH;
        t.setManosDeObras(this);

    }

    public void setManosXReparaciones(ManoXReparacion a){
        this.manosXReparaciones.add(a);
    }


    public int getCodigo(){
        return this.codigo;
    }

    public ArrayList<ManoXReparacion> getManosXReparaciones(){
        return this.manosXReparaciones;
    }

    public Tecnico getTecnico(){
        return this.tecnico;
    }

}
