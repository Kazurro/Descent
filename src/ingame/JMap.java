package ingame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JMap extends JPanel {
    
    public static Mapa mapa = null;
    
    // Array que almacena casillas ocupadas    
    public static ArrayList<Casilla> caOcupadas = new ArrayList();

    @Override public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        // Tamaño de los cuadrados (Width y Height)
        mapa = new Mapa(1600, 704);
        
        // Le da valores predeterminados al Mapa
        int tamaño = 32;
        int nX = 1;
        int nY = 1;

        // Asigna un numero entero a una casilla ocupada.
        int numCasilla = 1;

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

        Iterator<Casilla> it = mapa.getCasillas().iterator();

        numCasilla = 0;
        while (it.hasNext()) {
            Casilla casilla = it.next();
            BufferedImage imgPrint = imgTerreno.getSubimage(casilla.getTipo()[0], casilla.getTipo()[1], tamaño, tamaño);

            if (mapa.getIniX() >= mapa.getTamañoX() + 160) {
                mapa.setIniX(160);
                mapa.setIniY(mapa.getIniY() + tamaño);
                nX = 1;
                nY += 1;
            }
            // Color a la rejilla del cuadrado (AZUL)
            if (casilla.isOcupable() == true) {
                g2.setColor(Color.red);
                // Array que almacena casillas ocupadas
                caOcupadas.add(casilla);
                // Asignación de un numero a una casilla
                casilla.setNumcasilla(numCasilla);
                numCasilla += 1;
            }

            //Dibuja Casilla
            g2.drawImage(imgPrint, mapa.getIniX(), mapa.getIniY(), this);

            // Le da las coordenadas a la casilla (NUEVO)
            casilla.setCoordenadas(mapa.getIniX() - 128 + 15, mapa.getIniY() - 64 + 15); // IGUAL HACE COSAS RARAS
            casilla.setPosicion(nX, nY);
            nX += 1;

            // Dibuja el cuadrado
            if (casilla.isOcupable() == true) {
                g2.drawRect(mapa.getIniX(), mapa.getIniY(), tamaño, tamaño);
            }

            mapa.setIniX(mapa.getIniX() + tamaño);
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
