package ingame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class OvalPanel extends JPanel {

    @Override public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        // Los tamaños de los pixeles quedan en 32px
        int tamañoPantallaX = 1600; // 1600 (50 * 32px) //1650 (50 * 33px)
        int tamañoPantallay = 704; // 704 (22 * 32px)// 704 (22 * 33px)
        
        // Tamaño de los cuadrados
        int width = 32;
        int height = 32;
        
        // Posición de salida 
        int posicionx = 160;//160 (32px)//135 (33px)
        int posiciony = 188;//188 (32px)//177 (33px)

        ArrayList<Casilla> lista = new ArrayList();
        Scanner scM;
        try {
            String[] cadena;

            scM = new Scanner(new File("mapa1.txt"));
            while (scM.hasNext()) {
                cadena = scM.nextLine().split("\\|");

                for (int i = 0; i < cadena.length; i++) {

                    lista.add(new Casilla(cadena[i]));
                }

            }

            scM.close();

        } catch (IOException ex) {}

        BufferedImage imagen = null;

        try {
            imagen = ImageIO.read(new File("resources/2.png"));
        } catch (IOException ex) {}
        
        int contary = 0;
        int contarx = 0;
        Iterator<Casilla> it = lista.iterator();
        while (it.hasNext()) {
            Casilla e = it.next();
            BufferedImage img = imagen.getSubimage(e.getTipo()[0], e.getTipo()[1], width, height);
            if (posicionx >= tamañoPantallaX + 160) {
                System.out.println("num vueltas X " + contarx + "num vueltas y " + contary);
                posicionx = 160;
                posiciony += 32;
                contary += 1;
            }

            contarx += 1;
            // Color a la rejilla del cuadrado
           // g2.setColor(Color.yellow);

            //Dibuja Casilla
            g2.drawImage(img, posicionx, posiciony, this);

            // Dibuja el cuadrado
            //g2.drawRect(posicionx, posiciony, width, height);
            posicionx += 32;

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
