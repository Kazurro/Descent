package characters;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;
import ingame.Casilla;
import ingame.JMap;
import items.Arma;
import items.Armadura;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import main.Globals;
import util.Animation;

public class Heroe extends Personaje {

    private Arma arma;
    private Armadura armadura;

    // Coordenadas
    private final Keyboard keyboard;
    private final Gamepad gamepad;
    private int nX, nY;
    private int y = 0, x = 0;

    private int contador = 0;

    // Gestiona el Keyboard asociado al heroe
    public Keyboard getKeyboard() {
        return this.keyboard;
    }

    public Gamepad getGamePad() {
        return this.gamepad;
    }

    // Constructor del Heroe (Hereda de Generic)
    public Heroe(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);

        keyboard = this.new Keyboard();
        gamepad = this.new Gamepad();
        ArrayListed.heroes.add(this);
    }

    // Administra los cambios de Stats del heroe al equipar Items
    public void equiparArma() {
        super.setDaño(arma.getDaño());
        super.setMovimiento(-arma.getPeso());
        super.setRango(arma.getRango());
    }

    public void equiparArmadura() {
        super.setVida(armadura.getVida());
        super.setMovimiento(-armadura.getPeso());
        super.setDefensa(armadura.getDefensa());
    }

    public void desequiparArma() {
        super.setDaño(-arma.getDaño());
        super.setMovimiento(+arma.getPeso());
        super.setRango(-arma.getRango());
    }

    public void desequiparArmadura() {
        super.setVida(-armadura.getVida());
        super.setMovimiento(+armadura.getPeso());
        super.setDefensa(-armadura.getDefensa());
    }

    public void moverCasilla(int nX, int nY) {

        for (Casilla casilla : JMap.mapa.getCasillas()) {

            if (casilla.getnX() == nX && casilla.getnY() == nY) {

                if (Heroe.this.getMovimiento() > contador) {

                    if (casilla.isOcupable() == true) {
                        casilla.setHabitante(Heroe.this);
                        this.nX = nX;
                        this.nY = nY;
                        x = casilla.getX();
                        y = casilla.getY();

                        contador += 1;
                        break;
                    }
                }

            }
        }
    }

    // Clase Interna del Heroe que permite su movimiento y animación
    public class Keyboard implements KeyListener {

        private JLabel label;      

        // Asigna el JLabel en el que se generara el Heroe para administrar sus movimientos
        public Keyboard() {
            
            nY = 8;
            nX = 4;
        }

        public void setLabel(JLabel label) {

            this.label = label;
            Globals.Partida.addKeyListener(Keyboard.this);
            Globals.Partida.setFocusable(true);
        }

        public void transferListener() {
            contador = 0;
            Globals.Partida.removeKeyListener(Keyboard.this);
        }

        @Override public void keyTyped(KeyEvent e) {
            Globals.Partida.repaint();
            
            switch (KeyEvent.getKeyText(e.getKeyCode())) {
                case "Arriba":
                    moverCasilla(nX, nY - 1);
                    label.setIcon(getSprite().getTopAnimation());
                    break;
                case "Derecha":
                    moverCasilla(nX + 1, nY);
                    label.setIcon(getSprite().getRightAnimation());
                    break;
                case "Abajo":
                    moverCasilla(nX, nY + 1);
                    label.setIcon(getSprite().getBottomAnimation());
                    break;
                case "Izquierda":
                    moverCasilla(nX - 1, nY);
                    label.setIcon(getSprite().getLeftAnimation());
                    break;
                default:
                    moverCasilla(nX, nY);
                    break;
            }

            label.setLocation(x, y);
            label.repaint();
        }

        @Override public void keyPressed(KeyEvent e) {
            Globals.Partida.repaint();
            
            switch (KeyEvent.getKeyText(e.getKeyCode())) {
                case "Arriba":
                    moverCasilla(nX, nY - 1);
                    label.setIcon(getSprite().getTopAnimation());
                    break;
                case "Derecha":
                    moverCasilla(nX + 1, nY);
                    label.setIcon(getSprite().getRightAnimation());
                    break;
                case "Abajo":
                    moverCasilla(nX, nY + 1);
                    label.setIcon(getSprite().getBottomAnimation());
                    break;
                case "Izquierda":
                    moverCasilla(nX - 1, nY);
                    label.setIcon(getSprite().getLeftAnimation());
                    break;
                default:
                    moverCasilla(nX, nY);
                    break;
            }

            label.setLocation(x, y);
            label.repaint();
        }

        @Override public void keyReleased(KeyEvent e) {}
    }

    // Clase Interna del Heroe que permite su movimiento y animación con mando de XBox
    public class Gamepad {

        private final XboxController xc = new XboxController();

        public Gamepad() {

            xc.setLeftThumbDeadZone(0.2);
        }

        public void transferListener() {

            xc.addXboxControllerListener(null);
        }

        public void setGamePad(JLabel label) {

            xc.addXboxControllerListener(new XboxControllerAdapter() {
                @Override public void isConnected(boolean connected) {

                    if (!connected) {

                        JOptionPane.showMessageDialog(null, "El mando se ha desconectado.");
                        //xc.release(); // Libera xc
                    }
                }

                // Pad Cuadriculado
                @Override public void dpad(int direction, boolean pressed) {

                    Globals.Partida.repaint();

                    switch (direction) {
                        case 0:
                            moverCasilla(nX, nY - 1);
                            label.setIcon(getSprite().getTopAnimation());
                            break;
                        case 1: break;
                        case 2:
                            moverCasilla(nX + 1, nY);
                            label.setIcon(getSprite().getRightAnimation());
                            break;
                        case 3: break;
                        case 4:
                            moverCasilla(nX, nY + 1);
                            label.setIcon(getSprite().getBottomAnimation());
                            break;
                        case 5: break;
                        case 6:
                            moverCasilla(nX - 1, nY);
                            label.setIcon(getSprite().getLeftAnimation());
                            break;
                        case 7: break;
                    }

                    label.setLocation(x, y);
                    label.repaint();
                }

                // Thumb Izquierdo
                @Override public void leftThumbDirection(double direction) {
                    Globals.Partida.repaint();

                    if (direction > 315 && direction < 360 || direction > 0 && direction < 45) {
                        moverCasilla(nX, nY - 1);
                        label.setIcon(getSprite().getTopAnimation());
                    } else if (direction > 45 && direction < 135) {
                        moverCasilla(nX + 1, nY);
                        label.setIcon(getSprite().getRightAnimation());
                    } else if (direction > 135 && direction < 225) {
                        moverCasilla(nX, nY + 1);
                        label.setIcon(getSprite().getBottomAnimation());
                    } else if (direction > 225 && direction < 315) {
                        moverCasilla(nX - 1, nY);
                        label.setIcon(getSprite().getLeftAnimation());
                    }

                    label.setLocation(x, y);
                    label.repaint();
                }
            });
        }
    }
}
