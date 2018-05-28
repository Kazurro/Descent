package characters;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Animation {
    
    private Timer timer;
    private TimerTask task = null;
    private final JLabel label;
    private final String ruta;
    private BufferedImage image;
    private int x = 0;
    private int y = 0;

    // Constructor
    
    public Animation(String ruta, JLabel label) {
        this.ruta = ruta;
        this.label = label;
        try {
            image = ImageIO.read(new File(ruta));
        } catch (IOException ex) {}
    }
    
    // Cara del Sprite

    public void startAnimation() {
        
        timer = new Timer();
        
        task = new TimerTask() {
            @Override public void run() {
                
                if (x >= 960){
                    
                    x = 0;
                    y += 192;
                }
                
                if (y >= 1152){
                    timer.cancel();
                    x = 0;
                    y = 0;
                } else {
                    BufferedImage img = image.getSubimage(x, y, 192, 192);
                    label.setIcon(new ImageIcon(img));
                    x += 192;
                }
            }
        };
        timer.schedule(task, 0, 100);
    }

}
