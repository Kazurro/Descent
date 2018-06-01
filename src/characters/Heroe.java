package characters;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;
import static ingame.Game.ContenedorMapa;
import static ingame.Game.PanelHeroes;
import static ingame.Game.jF;
import static ingame.Game.jP;
import items.Arma;
import items.Armadura;
import java.awt.Color;
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
    private int y = 0;
    private int x = 0;

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

    // Clase Interna del Heroe que permite su movimiento y animación
    public class Keyboard implements KeyListener {

        private Animation animacion;
        private JLabel label;

        // Asigna el JLabel en el que se generara el Heroe para administrar sus movimientos
        public Keyboard() {
            //y = (int) label.getLocation().getY();
            //x = (int) label.getLocation().getX();
            y = 400;
            x = 140;
        }

        public void setLabel(JLabel label) {

            this.label = label;
            Globals.Partida.addKeyListener(Keyboard.this);
            Globals.Partida.setFocusable(true);

        }

        public void setAnimation(Animation animacion) {

            this.animacion = animacion;
        }

        public void transferListener() {

            Globals.Partida.removeKeyListener(Keyboard.this);

        }

        @Override
        public void keyTyped(KeyEvent e) {
            Globals.Partida.repaint();
                    ContenedorMapa.add(jP);
        ContenedorMapa.add(jF);
        ContenedorMapa.setSize(Globals.fullScreen);
        ContenedorMapa.setPreferredSize(Globals.fullScreen);
        

        PanelHeroes.setBackground(new Color(0, 0, 0, 0));
        PanelHeroes.setSize(Globals.fullScreen);
        PanelHeroes.setPreferredSize(Globals.fullScreen);
            // Globals.Partida.PanelHeroes.repaint();
            switch (KeyEvent.getKeyText(e.getKeyCode())) {
                case "Arriba":
                    y -= 10;
                    label.setIcon(getSprite().getTopAnimation());
                    break;
                case "Derecha":
                    x += 10;
                    label.setIcon(getSprite().getRightAnimation());
                    break;
                case "Abajo":
                    y += 10;
                    label.setIcon(getSprite().getBottomAnimation());
                    break;
                case "Izquierda":
                    x -= 10;
                    label.setIcon(getSprite().getLeftAnimation());
                    break;
                case "R":
                    animacion.startAnimation();
                    break;
                default:
                    break;
            }

            label.setLocation(x, y);
            label.repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            Globals.Partida.repaint();            
                    ContenedorMapa.add(jP);
        ContenedorMapa.add(jF);
        ContenedorMapa.setSize(Globals.fullScreen);
        ContenedorMapa.setPreferredSize(Globals.fullScreen);
        

        PanelHeroes.setBackground(new Color(0, 0, 0, 0));
        PanelHeroes.setSize(Globals.fullScreen);
        PanelHeroes.setPreferredSize(Globals.fullScreen);
          
            switch (KeyEvent.getKeyText(e.getKeyCode())) {
                case "Arriba":
                    y -= 10;
                    label.setIcon(getSprite().getTopAnimation());
                    break;
                case "Derecha":
                    x += 10;
                    label.setIcon(getSprite().getRightAnimation());
                    break;
                case "Abajo":
                    y += 10;
                    label.setIcon(getSprite().getBottomAnimation());
                    break;
                case "Izquierda":
                    x -= 10;
                    label.setIcon(getSprite().getLeftAnimation());
                    break;
                case "R":
                    animacion.startAnimation();
                    break;
                default:
                    break;
            }

            label.setLocation(x, y);
            label.repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    // Clase Interna del Heroe que permite su movimiento y animación con mando de XBox
    public class Gamepad {

        private XboxController xc;

        public Gamepad() {

            xc = new XboxController();
            xc.setLeftThumbDeadZone(0.2);
        }

        public void transferListener() {

            xc.addXboxControllerListener(null);
        }

        public void setGamePad(JLabel label) {

            xc.addXboxControllerListener(new XboxControllerAdapter() {
                @Override
                public void isConnected(boolean connected) {

                    if (!connected) {

                        JOptionPane.showMessageDialog(null, "El mando se ha desconectado.");
                        //xc.release(); // Libera xc
                    }
                }

                // Pad Cuadriculado
                @Override
                public void dpad(int direction, boolean pressed) {

                    Globals.Partida.PanelHeroes.repaint();

                    switch (direction) {
                        case 0:
                            y -= 10;
                            label.setIcon(getSprite().getTopAnimation());
                            break;
                        case 1:
                            break;
                        case 2:
                            x += 10;
                            label.setIcon(getSprite().getRightAnimation());
                            break;
                        case 3:
                            break;
                        case 4:
                            y += 10;
                            label.setIcon(getSprite().getBottomAnimation());
                            break;
                        case 5:
                            break;
                        case 6:
                            x -= 10;
                            label.setIcon(getSprite().getLeftAnimation());
                            break;
                        case 7:
                            break;
                    }

                    label.setLocation(x, y);
                    label.repaint();
                }

                // Thumb Izquierdo
                @Override
                public void leftThumbDirection(double direction) {

                    Globals.Partida.PanelHeroes.repaint();

                    if (direction > 315 && direction < 360 || direction > 0 && direction < 45) {
                        y -= 10;
                        label.setIcon(getSprite().getTopAnimation());
                    } else if (direction > 45 && direction < 135) {
                        x += 10;
                        label.setIcon(getSprite().getRightAnimation());
                    } else if (direction > 135 && direction < 225) {
                        y += 10;
                        label.setIcon(getSprite().getBottomAnimation());
                    } else if (direction > 225 && direction < 315) {
                        x -= 10;
                        label.setIcon(getSprite().getLeftAnimation());
                    }

                    label.setLocation(x, y);
                    label.repaint();
                }
            });
        }
    }

}
