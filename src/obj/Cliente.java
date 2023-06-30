package obj;

public class Cliente {

    private String nombre;
    private String tipoDoc;
    private String doc;
    private float ctaCte;
    private float limiteCtaCte;

    public boolean soyEseCleinte(String documento){
        return this.doc == documento;
    }
    public void registrarCliente(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte){
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.ctaCte = ctaCte;
        this.limiteCtaCte = limiteCtaCte;
    }
    public boolean mePasoEnDeuda(float precio){
        if(ctaCte + precio <= limiteCtaCte){
            return false;
        }else {
            return true;
        }
    }
    public void actualizarCta(float precio){
        ctaCte += precio;
    }


}
