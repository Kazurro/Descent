package main;

import static characters.Heroe.heroes;
import characters.Heroe;
import characters.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import util.*;

public class newGame extends javax.swing.JPanel {
    
    private Keyboard keyboard;
    private Gamepad heroe1;
    
    public newGame() {
        initComponents();
        Globals.setGame(this);
        this.setBounds(Globals.location);
        
        // Asesino
        new Heroe("Asesino", new Sprite("resources/sprites/heroes/asesino/"), 12, 5, 2, 4, 1);
        
        // Guerrero
        //new Heroe("Cleriga", new ImageIcon("resources/sprites/heroes/cleriga.gif"), 16, 2, 2,3, 2);
        new Heroe("Guerrero", new Sprite("resources/sprites/heroes/guerrero/"), 18, 4, 2,3, 1);
        //new Heroe("Luchador", new ImageIcon("resources/sprites/heroes/luchador.gif"), 16, 5, 2,3, 2);
        //new Heroe("Mago", new ImageIcon("resources/sprites/heroes/mago.gif"), 12, 4, 2,3, 3);
        //new Heroe("Paladin", new ImageIcon("resources/sprites/heroes/paladin.gif"), 18, 4, 2, 3, 1);
        setupComboBox(cbHeroe1);
        
        this.add(Globals.addBackground(new JLabel()));
        Globals.setBackground(Globals.fullScreen, "resources/mapa1.jpg");//new Color(0, 0, 0, 0));
        Globals.getBackground().setVisible(true);
    }

    public static void setupComboBox(JComboBox seleccion){
        
        ArrayList<String> selHeroes = new ArrayList<>();
        
        heroes.forEach((heroe) -> {
            selHeroes.add(heroe.getNombre());
        });
        
        seleccion.setModel(new DefaultComboBoxModel(selHeroes.toArray()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHeroe1 = new javax.swing.JLabel();
        cbHeroe1 = new javax.swing.JComboBox<>();
        prueba = new javax.swing.JLabel();
        lbHeroe2 = new javax.swing.JLabel();
        cbHeroe2 = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lbHeroe1.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe1);
        lbHeroe1.setBounds(76, 61, 190, 144);

        cbHeroe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe1ActionPerformed(evt);
            }
        });
        add(cbHeroe1);
        cbHeroe1.setBounds(76, 223, 190, 33);

        prueba.setMinimumSize(new java.awt.Dimension(48, 48));
        add(prueba);
        prueba.setBounds(160, 410, 48, 48);

        lbHeroe2.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe2);
        lbHeroe2.setBounds(310, 60, 190, 144);

        cbHeroe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe2ActionPerformed(evt);
            }
        });
        add(cbHeroe2);
        cbHeroe2.setBounds(310, 220, 190, 33);
    }// </editor-fold>//GEN-END:initComponents

    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed
        
        lbHeroe1.setIcon(new ImageIcon(heroes.get(cbHeroe1.getSelectedIndex()).getSprite().getCara()));
        keyboard = new Keyboard(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
        heroe1 = new Gamepad(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
    }//GEN-LAST:event_cbHeroe1ActionPerformed

    private void cbHeroe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHeroe2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JComboBox<String> cbHeroe2;
    private javax.swing.JLabel lbHeroe1;
    private javax.swing.JLabel lbHeroe2;
    private static javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
