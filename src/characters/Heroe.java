package characters;

import items.Arma;
import items.Armadura;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import main.Globals;
import util.Animation;

public class Heroe extends Generic {
    
    private Arma arma;
    private Armadura armadura;
    private Keyboard keyboard;

    // Gestiona el Keyboard asociado al heroe
    
    public Keyboard getKeyboard() {
        return keyboard;
    }
    
    // Constructor del Heroe (Hereda de Generic)
    
    public Heroe(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);
        
        keyboard = this.new Keyboard(sprite);
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
    
        private Sprite sprite;
        private Animation animacion;
        private JLabel label;
        private int y = 0;
        private int x = 0;
    
        // Asigna el JLabel en el que se generara el Heroe para administrar sus movimientos
        
        public Keyboard(Sprite sprite){
        
            this.sprite = sprite;
            //y = (int) label.getLocation().getY();
            //x = (int) label.getLocation().getX();
            y = 400;
            x = 140;
            
        }
        
        public void setLabel(JLabel label){
        
            this.label = label;
            Globals.Main.addKeyListener(Keyboard.this);
            Globals.Main.setFocusable(true);
        }
    
        public void setAnimation(Animation animacion){
        
            this.animacion = animacion;
        }
    
        @Override public void keyTyped(KeyEvent e) {
        
            Globals.Main.repaint();
        
            switch(KeyEvent.getKeyText(e.getKeyCode())){
                case "Arriba": y -= 10; label.setIcon(sprite.getTopAnimation());  break;
                case "Derecha": x += 10; label.setIcon(sprite.getRightAnimation());  break;
                case "Abajo": y += 10; label.setIcon(sprite.getBottomAnimation());  break;
                case "Izquierda": x -= 10; label.setIcon(sprite.getLeftAnimation());  break;
                case "R": animacion.startAnimation(); break;
                default: break;
            }
        
            label.setLocation(x, y);label.repaint();
        }

        @Override public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            Globals.Main.repaint();

            switch(KeyEvent.getKeyText(e.getKeyCode())){
                case "Arriba": y -= 10; label.setIcon(sprite.getTopAnimation()); break;
                case "Derecha": x += 10; label.setIcon(sprite.getRightAnimation()); break;
                case "Abajo": label.setIcon(sprite.getBottomAnimation()); y += 10; break;
                case "Izquierda": label.setIcon(sprite.getLeftAnimation()); x -= 10; break;
                case "R": animacion.startAnimation(); break;
                default: break;
            }
                
            label.setLocation(x, y);label.repaint();
        }

        @Override public void keyReleased(KeyEvent e) {}
    }
    
}
