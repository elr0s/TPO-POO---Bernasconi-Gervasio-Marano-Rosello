package obj;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int año;
    private Cliente dueño;

    public boolean soyEseVehiculo(String patente) {
        return this.patente.equals(patente);
    }

    public void registrarVehiculo(String patente, String marca, String modelo, int año, Cliente dueño) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.dueño = dueño;
    }

    public String getPatente() {
        return this.patente;
    }

   
}

