package ingame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JMap extends JPanel {

    public static Mapa mapa = null;
    
    @Override public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        // Tamaño de los cuadrados (Width y Height)
        mapa = new Mapa(1600, 704);
        int tamaño = 32;
                
        // Posición de salida 
        int inicialX = 160;//160 (32px)//135 (33px)
        int inicialY = 188;//188 (32px)//177 (33px)
        
        int nX = 1;
        int nY = 1;

        // Escanea el fichero con las posiciones del Mapa y los añade a la clase 'Mapa'
        try {
            Scanner scM = new Scanner(new File("mapa1.txt"));
            String[] cadena;
            
            while (scM.hasNext()) {
                cadena = scM.nextLine().split("\\|");

                for (String terreno: cadena) {

                    mapa.getCasillas().add(new Casilla(terreno));
                }
            }
            
            scM.close();
        } catch (FileNotFoundException ex) {}
       
        // Pinta la imagen de la respectiva casilla en el Panel 'JMap'
        BufferedImage imgTerreno = null;

        try {
            imgTerreno = ImageIO.read(new File("resources/2.png"));
        } catch (IOException ex) {}

        //Iterator<Casilla> it = lista.iterator();
        Iterator<Casilla> it = mapa.getCasillas().iterator();
        
        while (it.hasNext()) {
            Casilla casilla = it.next();    
            BufferedImage imgPrint = imgTerreno.getSubimage(casilla.getTipo()[0], casilla.getTipo()[1], tamaño, tamaño);
            
            if (inicialX >= mapa.getTamañoX() + 160) {
                inicialX = 160;
                inicialY += 32;
                nX = 1;
                nY += 1;
            }
            // Color a la rejilla del cuadrado (AZUL)
            if (casilla.isOcupable() == true){
                g2.setColor(Color.red); 
            }
           

            //Dibuja Casilla
            g2.drawImage(imgPrint, inicialX, inicialY, this);
            
            // Le da las coordenadas a la casilla (NUEVO)
            casilla.setCoordenadas(inicialX - 128 + 15, inicialY - 64 + 15); // IGUAL HACE COSAS RARAS
            casilla.setPosicion(nX, nY);
            nX += 1;
            
            // Dibuja el cuadrado
            if (casilla.isOcupable() == true){
                g2.drawRect(inicialX, inicialY, tamaño, tamaño);
            }
            
            inicialX += 32;
            System.out.println(casilla.toString());
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setForeground(new java.awt.Color(255, 255, 255));

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
