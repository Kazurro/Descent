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
    public ImageIcon getLeftAnimation(){
        
        BufferedImage img = this.getLeft1();
        
        switch(contador){
            case 1: img = this.getLeft1(); contador += 1; break;
            case 2: img = this.getLeft2(); contador += 1; break;
            case 3: img = this.getLeft3(); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
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
    public ImageIcon getRightAnimation(){
        
        BufferedImage img = this.getRight1();
        
        switch(contador){
            case 1: img = this.getRight1(); contador += 1; break;
            case 2: img = this.getRight2(); contador += 1; break;
            case 3: img = this.getRight3(); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    public BufferedImage getRight1(){
        return direccion.getSubimage(0, 96, 48, 48);
    } 
    public BufferedImage getRight2(){
        return direccion.getSubimage(50, 96, 47, 47);
    } 
    public BufferedImage getRight3(){
        return direccion.getSubimage(100, 96, 47, 47);
    }
    
    // Dirección Abajo
    public ImageIcon getBottomAnimation(){
        
        BufferedImage img = this.getBottom1();
        
        switch(contador){
            case 1: img = this.getBottom1(); contador += 1; break;
            case 2: img = this.getBottom2(); contador += 1; break;
            case 3: img = this.getBottom3(); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    
    public BufferedImage getBottom1(){
        return direccion.getSubimage(0, 0, 48, 48);
    } 
    public BufferedImage getBottom2(){
        return direccion.getSubimage(50, 0, 47, 47);
    } 
    public BufferedImage getBottom3(){
        return direccion.getSubimage(100, 0, 47, 47);
    }
    
    // Dirección Arriba
    public ImageIcon getTopAnimation(){
        
        BufferedImage img = this.getTop1();
        
        switch(contador){
            case 1: img = this.getTop1(); contador += 1; break;
            case 2: img = this.getTop2(); contador += 1; break;
            case 3: img = this.getTop3(); contador += 1; break;
            default: contador = 1; break;
        }
        
        return new ImageIcon(img);
    }
    public BufferedImage getTop1(){
        return direccion.getSubimage(0, 145, 48, 48);
    } 
    public BufferedImage getTop2(){
        return direccion.getSubimage(50, 145, 47, 47);
    } 
    public BufferedImage getTop3(){
        return direccion.getSubimage(100, 145, 47, 47);
    }
}
