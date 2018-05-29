package util;

import characters.Sprite;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import main.Globals;

public class Keyboard implements KeyListener {
    
    private Sprite sprite;
    private Animation animacion;
    private JLabel label;
    private int y = 0;
    private int x = 0;
    
    public Keyboard(JLabel label, Sprite sprite){
        
        this.sprite = sprite;
        this.label = label;
        y = (int) label.getLocation().getY();
        x = (int) label.getLocation().getX();
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
