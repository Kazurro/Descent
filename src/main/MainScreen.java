package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainScreen extends javax.swing.JFrame {
    
    public MainScreen() {
        initComponents();

        this.setIconImage(new ImageIcon("src/resources/icon.png").getImage());
        
        // Ajusta la ventana a Full Screen
        Globals.Main = MainScreen.this;
        this.setSize(Globals.fullScreen);
        
        // Añade el panel Principal

        this.add(new Principal());
        
        // Añade al Background el fondo 1 a Full Screen
        
        this.add(Globals.addBackground(new JLabel()));
        Globals.setBackground(Globals.fullScreen, "src/resources/background1.jpg");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
