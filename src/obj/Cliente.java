package obj;

public class Cliente {

    private String nombre;
    private String tipoDoc;
    private String doc; // No se declara como estático
    private float ctaCte;
    private float limiteCtaCte;
    
    
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
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDoc(){
        return doc;
    }
    
    public String getTipoDoc() {
    	return tipoDoc;
    }
    
    public float getCtaCte() {
    	return ctaCte;
    }
    public float getLimiteCtaCte() {
    	return limiteCtaCte;
    }
    
    public boolean soyEseCliente(String documento){
        return doc.equals(documento);
    }

    public void registrarCliente(String nombre, String tipoDoc, String doc, float ctaCte, float limiteCtaCte){
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.doc = doc; // No se asigna a través de la clase Cliente
        this.ctaCte = ctaCte;
        this.limiteCtaCte = limiteCtaCte;
    }

    public boolean mePasoEnDeuda(float precio){
        return (ctaCte + precio) > limiteCtaCte;
    }

    
    public void actualizarCta(float precio){
        ctaCte += precio;
    }


    
  }
    
    