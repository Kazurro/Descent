package characters;

public class Monstruo extends Personaje {

    // Coordenadas
    private int nX, nY;
    private int y = 0, x = 0;

    // Constructor del Heroe (Hereda de Generic)
    public Monstruo(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);
        
        ArrayListed.monstruos.add(this);
    }

    /*public void numRandom(JLabel label) {

        int valorEntero = (int) Math.floor(Math.random() * (1 - 592 + 1) + 592);
        // System.out.println("Casillas ocupasdas" + JMap.caOcupadas.size());
        for (Casilla casilla : JMap.caOcupadas) {

            if (casilla.getNumcasilla() == valorEntero) {

                System.out.println(casilla.getX() + " " + casilla.getY());
                label.setLocation(casilla.getX(), casilla.getY());
                label.setIcon(new ImageIcon());
                label.repaint();
            }

        }
    }*/
}
