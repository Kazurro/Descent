package characters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
    
    private final String ruta;
    private BufferedImage cara;
    private BufferedImage direccion;
    private BufferedImage death;
    private BufferedImage movement;

    // Constructor
    
    public Sprite(String ruta) {
        this.ruta = ruta;
        
        try {
            cara = ImageIO.read(new File(ruta + "1.png")).getSubimage(0, 0, 144, 144);
            direccion = ImageIO.read(new File(ruta + "2.png"));
        } catch (IOException ex) {}
    }
    
    // Cara del Sprite

    public BufferedImage getCara() {
        return cara;
    }
    
    // Dirección Izquierda
    public BufferedImage getLeft1(){
        return direccion.getSubimage(0, 50, 48, 48);
    } 
    public BufferedImage getLeft2(){
        return direccion.getSubimage(50, 50, 47, 47);
    } 
    public BufferedImage getLeft3(){
        return direccion.getSubimage(100, 50, 47, 47);
    }
    
    // Dirección Derecha
    public BufferedImage getRight1(){
        return direccion.getSubimage(0, 96, 48, 48);
    } 
    public BufferedImage getRight2(){
        return direccion.getSubimage(50, 96, 47, 47);
    } 
    public BufferedImage getRight3(){
        return direccion.getSubimage(100, 96, 47, 47);
    }
    
        // Dirección Izquierda
    public BufferedImage getTop1(){
        return direccion.getSubimage(0, 0, 48, 48);
    } 
    public BufferedImage getTop2(){
        return direccion.getSubimage(50, 0, 47, 47);
    } 
    public BufferedImage getTop3(){
        return direccion.getSubimage(100, 0, 47, 47);
    }
    
    // Dirección Derecha
    public BufferedImage getBottom1(){
        return direccion.getSubimage(0, 145, 48, 48);
    } 
    public BufferedImage getBottom2(){
        return direccion.getSubimage(50, 145, 47, 47);
    } 
    public BufferedImage getBottom3(){
        return direccion.getSubimage(100, 145, 47, 47);
    }
}
