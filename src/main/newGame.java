package main;

import characters.Animation;
import static characters.Heroe.heroes;
import characters.Heroe;
import characters.Sprite;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import util.*;

public class newGame extends javax.swing.JPanel {
    
    private Keyboard keyboard;
    private Gamepad heroe1;
    private Animation animacion;
    
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
        lbAnimacion = new javax.swing.JLabel();

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

        prueba.setFocusTraversalPolicyProvider(true);
        prueba.setMinimumSize(new java.awt.Dimension(48, 48));
        add(prueba);
        prueba.setBounds(113, 400, 48, 48);
        add(lbAnimacion);
        lbAnimacion.setBounds(830, 120, 160, 130);
    }// </editor-fold>//GEN-END:initComponents

    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed
        this.prueba.setIcon(null); prueba.repaint();
        lbHeroe1.setIcon(new ImageIcon(heroes.get(cbHeroe1.getSelectedIndex()).getSprite().getCara()));
        keyboard = new Keyboard(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
        
        heroe1 = new Gamepad(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
        keyboard.setAnimation(new Animation("resources/Animaciones/slash3.png", lbAnimacion));
    }//GEN-LAST:event_cbHeroe1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JLabel lbAnimacion;
    private javax.swing.JLabel lbHeroe1;
    private static javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
