package util;

import characters.Sprite;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Globals;

public class Keyboard implements KeyListener {
    
    private int contador = 1;
    private final Sprite sprite;
    private final JLabel label;
    
    public Keyboard(JLabel label, Sprite sprite){
        
        this.sprite = sprite;
        this.label = label;
        Globals.Main.addKeyListener(Keyboard.this);
        Globals.Main.setFocusable(true);
    }
    
    public BufferedImage animacion(BufferedImage img1, BufferedImage img2, BufferedImage img3){
        
        BufferedImage img = img1;
        
        switch(contador){
            case 1: img = img1; contador += 1; break;
            case 2: img = img2; contador += 1; break;
            case 3: img = img3; contador += 1; break;
            default: contador = 1; break;
        }
        
        return img;
    }
    
    @Override public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped="+KeyEvent.getKeyText(e.getKeyCode()));
        
        switch(KeyEvent.getKeyText(e.getKeyCode())){
            case "Izquierda": label.setIcon(new ImageIcon(animacion(sprite.getLeft1(), sprite.getLeft2(), sprite.getLeft3()))); break;
            case "Derecha": label.setIcon(new ImageIcon(animacion(sprite.getRight1(), sprite.getRight2(), sprite.getRight3()))); break;
            case "Abajo": label.setIcon(new ImageIcon(animacion(sprite.getTop1(), sprite.getTop2(), sprite.getTop3()))); break;
            case "Arriba": label.setIcon(new ImageIcon(animacion(sprite.getBottom1(), sprite.getBottom2(), sprite.getBottom3()))); break;
            default: break;
        }
    }

    @Override public void keyPressed(KeyEvent e) {
	System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        
        TimerTask timerTask = new TimerTask() { 
            @Override public void run() { 
                
                switch(KeyEvent.getKeyText(e.getKeyCode())){
                    case "Izquierda": label.setIcon(new ImageIcon(animacion(sprite.getLeft1(), sprite.getLeft2(), sprite.getLeft3()))); break;
                    case "Derecha": label.setIcon(new ImageIcon(animacion(sprite.getRight1(), sprite.getRight2(), sprite.getRight3()))); break;
                    case "Abajo": label.setIcon(new ImageIcon(animacion(sprite.getTop1(), sprite.getTop2(), sprite.getTop3()))); break;
                    case "Arriba": label.setIcon(new ImageIcon(animacion(sprite.getBottom1(), sprite.getBottom2(), sprite.getBottom3()))); break;
                    default: break;
                } 
            } 
        }; 

        Timer timer = new Timer(); 
        timer.scheduleAtFixedRate(timerTask, 0, 100000000);    
    }

    @Override public void keyReleased(KeyEvent e) {
	
    }

}
