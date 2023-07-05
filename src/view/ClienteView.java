package view;

public class ClienteView {
    private String nombre;
    private String tipoDoc;
    private String doc;
    private float ctaCte;
    private float limiteCtaCte;

    public ClienteView(){

    }
    public ClienteView(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte){
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.ctaCte = ctaCte;
        this.limiteCtaCte = limiteCtaCte;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTipoDoc(String tipoDoc){
        this.tipoDoc = tipoDoc;
    }
    public void setDoc(String doc){
        this.doc = doc;
    }
    public void setCtaCte(float ctaCte){
        this.ctaCte = ctaCte;
    }
    public void setLimiteCtaCte(float limiteCtaCte){
        this.limiteCtaCte = limiteCtaCte;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipoDoc(){
        return tipoDoc;
    }
    public String getDoc(){
        return doc;
    }
    public float getCtaCte(){
        return ctaCte;
    }
    public float getLimiteCtaCte(){
        return limiteCtaCte;
    }
    /* HACE FALTA?
    * public String toString(){
    * return nombre + " : " + doc y asi
    * }*/
}

