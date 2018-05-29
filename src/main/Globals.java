package main;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Globals {
    
    // Adaptador de pantalla 1280 x 720 a Full Screen
    protected static Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
    protected static Rectangle location = new Rectangle(0, 0, fullScreen.width, fullScreen.height);
    
    // Ventanas de diseño del MainScreen
    public static JFrame Main;
    private static JLabel Background;
    private static Principal Principal;
    private static newGame Game;

    public static void setBackground(Dimension size, String rutaImagen) {
        
        Background.setSize(fullScreen);
        Background.setIcon(new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), java.awt.Image.SCALE_SMOOTH)));
    }

    public static JLabel getBackground() {
        return Background;
    }
    
    public static JLabel addBackground(JLabel background) {
        
        Background = background;
        
        return Background;
    }

    public static JPanel getPrincipal() {
        return Principal;
    } 
    public static void setPrincipal(Principal principal){
        
        Principal = principal;
    }
    
    public static newGame getGame() {
        return Game;
    }
    public static void setGame(newGame newGame){
        
        Game = newGame;
    }
}
