package ingame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class PanelFondo extends javax.swing.JPanel {

    @Override public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int tamañoPantallaX = this.getWidth();
        int tamañoPantallay = this.getHeight();

        // Tamaño de los cuadrados
        int width = 32;
        int height = 32;
        
         // Posición de salida 
        int posicionx = 0;//160 (32px)//135 (33px)
        int posiciony = 0;//188 (32px)//177 (33px)  

        BufferedImage imagen = null;

        try {
            imagen = ImageIO.read(new File("resources/2.png"));
        } catch (IOException ex) {
            Logger.getLogger(OvalPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedImage img = imagen.getSubimage(265, 32, 32, 32);
        do {
            if (posicionx > tamañoPantallaX) {
                posicionx = 0;
                posiciony += 32;
            }
            
            //Dibuja Casilla
            g2.drawImage(img, posicionx, posiciony, null);
          
            posicionx += 32;

        } while (posiciony <= tamañoPantallay);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
