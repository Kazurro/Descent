package main;

import ingame.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Globals {
    
    // Adaptador de pantalla 1280 x 720 a Full Screen
    public static Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
    public static Rectangle location = new Rectangle(0, 0, fullScreen.width, fullScreen.height);
    
    // Ventanas de diseño del MainScreen
    public static JFrame Main;
    private static JLabel Background;
    private static Principal Principal;
    private static newGame Seleccion;
    public static Game Partida;

    public static void setMain(JFrame mainInstance) {
        
        Main = mainInstance;
        Main.setSize(fullScreen);
        Main.setIconImage(new ImageIcon("resources/icon.png").getImage());
    }
    
    public static void setBackground(Dimension size, String rutaImagen) {
        
        Background.setSize(fullScreen);
        Background.setIcon(new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance((int) size.getWidth(), (int) size.getHeight(), java.awt.Image.SCALE_SMOOTH)));
    }

    // Gestiona el JLabel 'Background'
    
    public static JLabel getBackground() {
        
        return Background;
    }
    
    public static void setBackground(JLabel backgroundInstance, String rutaImagen) {

        Background = null;
        Background = backgroundInstance;
        Main.add(Background);
        Background.setIcon(new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance((int) fullScreen.getWidth(), (int) fullScreen.getHeight(), java.awt.Image.SCALE_SMOOTH)));
        Background.setSize(fullScreen);
    }

    // Gestiona el Panel 'Principal'
    
    public static JPanel getPrincipal() {
        
        return Principal;
    } 
    public static void setPrincipal(Principal principalInstance){
        
        Principal = principalInstance;
        Principal.setBounds(location);
        Principal.setBackground(new Color(0, 0, 0, 0));
    }
    
    // Gestiona el Panel 'NewGame'
    
    public static newGame getSeleccion() {
        return Seleccion;
    }
    public static void setSeleccion(newGame newGame){
        
        Seleccion = newGame;
        Seleccion.setBounds(location);
        Seleccion.setBackground(new Color(0, 0, 0, 0));
    }
}
