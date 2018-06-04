package characters;

public class Monstruo extends Personaje {

    // Coordenadas
    private int nX, nY;
    private int y = 0, x = 0;

    // Constructor del Heroe (Hereda de Generic)
    public Monstruo(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);

    }

}
