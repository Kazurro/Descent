package items;

public class Arma {

    private final String nombre;
    private final int daño;
    private final int peso;
    private final int rango;

    public Arma(String nombre, int daño, int peso, int rango) {
        this.nombre = nombre;
        this.daño = daño;
        this.peso = peso;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDaño() {
        return daño;
    }

    public int getPeso() {
        return peso;
    }

    public int getRango() {
        return rango;
    }
    
    
}
