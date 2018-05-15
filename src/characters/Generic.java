package characters;

public class Generic {

    private final Sprite sprite;
    private final String nombre;
    private int vida;
    private int daño;
    private int defensa;
    private int movimiento;
    private int rango;
    
    // Constructor

    public Generic(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        this.nombre = nombre;
        this.sprite = sprite;
        this.vida = vida;
        this.daño = daño;
        this.defensa = defensa;
        this.movimiento = movimiento;
        this.rango = rango;
    }
    
    // Metodo de Acceso

    public String getNombre() {
        return nombre;
    }

    public Sprite getSprite() {
        return sprite;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida += vida;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño += daño;
    }
    
    public int getDefensa() {
        return daño;
    }

    public void setDefensa(int defensa) {
        this.defensa += defensa;
    }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento += movimiento;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango += rango;
    }
}
