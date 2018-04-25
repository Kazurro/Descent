package items;

public class Armadura {
    
    private final String nombre;
    private final int vida;
    private final int peso;
    private final int defensa;

    public Armadura(String nombre, int vida, int peso, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.peso = peso;
        this.defensa = defensa;
    }
    
    // Metodos de Acceso

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getPeso() {
        return peso;
    }

    public int getDefensa() {
        return defensa;
    }
}
