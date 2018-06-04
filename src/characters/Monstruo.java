package characters;

import ingame.Casilla;
import ingame.JMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Monstruo extends Personaje {

    // Coordenadas
    private int nX, nY;
    private int y = 0, x = 0;

    // Constructor del Heroe (Hereda de Generic)
    public Monstruo(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);
        ArrayListed.monstruos.add(this);
    }

    // Metodo que genera un número aleatorio comprendido entre 1 y el número máximo de casillas ocupadas.
    public void numRandom(JLabel label) {

        int valorEntero = (int) Math.floor(Math.random() * (1 - 592 + 1) + 592);
        // System.out.println("Casillas ocupasdas" + JMap.caOcupadas.size());
        for (Casilla casilla : JMap.caOcupadas) {

            if (casilla.getNumcasilla() == valorEntero) {

                System.out.println(casilla.getX()+" "+casilla.getY());
                ImageIcon imagen=new ImageIcon(this.getSprite().getBottom1());
                label.setLocation(casilla.getX(), casilla.getY());
                label.setIcon(imagen);
                label.repaint();
            }

        }
    }
}
