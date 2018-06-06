package characters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite {
    
    private final String ruta;
    private BufferedImage cara;
    private BufferedImage direccion;
    private BufferedImage death;
    private BufferedImage movement;
    private int contador = 1;

    // Constructor
    
    public Sprite(String ruta) {
        this.ruta = ruta;
        
        // Carga la cara del personaje
        try {
            cara = ImageIO.read(new File(ruta + "1.png")).getSubimage(0, 0, 144, 144);
        } catch (IOException ex) {
            System.out.print("Fallo al cargar la cara.");
        }
        
        // Carga las direcciones del personaje
        try {
            direccion = ImageIO.read(new File(ruta + "2.png"));
        } catch (IOException ex){
            System.out.print("Fallo al cargar las direcciones.");
        }
    }
    
    // Cara del Sprite

    public BufferedImage getCara() {
        return cara;
    }
    
    // Dirección Izquierda
    public ImageIcon getLeftAnimation(){
        
        BufferedImage img = direccion.getSubimage(0, 50, 48, 48);
        
        switch(contador){
            case 1: img = direccion.getSubimage(0, 50, 48, 48); contador += 1; break;
            case 2: img = direccion.getSubimage(50, 50, 47, 47); contador += 1; break;
            case 3: img = direccion.getSubimage(100, 50, 47, 47); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    
    // Dirección Derecha
    public ImageIcon getRightAnimation(){
        
        BufferedImage img = direccion.getSubimage(0, 96, 48, 48);
        
        switch(contador){
            case 1: img = direccion.getSubimage(0, 96, 48, 48); contador += 1; break;
            case 2: img = direccion.getSubimage(50, 96, 47, 47); contador += 1; break;
            case 3: img = direccion.getSubimage(100, 96, 47, 47); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    
    // Dirección Abajo
    public ImageIcon getBottomAnimation(){
        
        BufferedImage img = direccion.getSubimage(0, 0, 48, 48);
        
        switch(contador){
            case 1: img = direccion.getSubimage(0, 0, 48, 48); contador += 1; break;
            case 2: img = direccion.getSubimage(50, 0, 47, 47); contador += 1; break;
            case 3: img = direccion.getSubimage(100, 0, 47, 47); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    
    // Dirección Arriba
    public ImageIcon getTopAnimation(){
        
        BufferedImage img = direccion.getSubimage(0, 145, 48, 48);
        
        switch(contador){
            case 1: img = direccion.getSubimage(0, 145, 48, 48); contador += 1; break;
            case 2: img = direccion.getSubimage(50, 145, 47, 47); contador += 1; break;
            case 3: img = direccion.getSubimage(100, 145, 47, 47); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
}
