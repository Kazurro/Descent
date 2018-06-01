package main;

import characters.ArrayListed;
import characters.Heroe;
import ingame.Game;
import util.Animation;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import util.ConexionBBDD;

public class newGame extends javax.swing.JPanel {
    
    private ConexionBBDD conexion; 
    private Heroe heroeSelected;
    private Heroe heroe1;
    private Heroe heroe2;
    private Heroe heroe3;
    private Heroe heroe4;
    
    
    
    public newGame() {
        initComponents();
        Globals.setGame(this);
        this.setBounds(Globals.location);
        
        // Genero una nueva conexión
        
        try {
            conexion = new ConexionBBDD("C:/Descent/BBDD.db");
            conexion.cargarHeroes();
            setupComboBox(cbHeroe1);
            setupComboBox(cbHeroe2);
            setupComboBox(cbHeroe3);
            setupComboBox(cbHeroe4);
        } catch (SQLException ex) {}
        
        // Carga el fondo de selección de Heroe
        
        Globals.getBackground().setVisible(false);
        this.add(Globals.addBackground(new JLabel()));
        Globals.setBackground(Globals.fullScreen, "resources/background2.jpg");
        Globals.getBackground().setVisible(true);
    }

    // Carga los heroes en el ComboBox
    
    public static void setupComboBox(JComboBox seleccion){
        
        ArrayList<String> selHeroes = new ArrayList<>();
        
        ArrayListed.heroes.forEach((heroe) -> {
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
        hpBar1 = new javax.swing.JProgressBar();
        lbHeroe2 = new javax.swing.JLabel();
        cbHeroe2 = new javax.swing.JComboBox<>();
        hpBar2 = new javax.swing.JProgressBar();
        lbHeroe3 = new javax.swing.JLabel();
        cbHeroe3 = new javax.swing.JComboBox<>();
        hpBar3 = new javax.swing.JProgressBar();
        lbHeroe4 = new javax.swing.JLabel();
        cbHeroe4 = new javax.swing.JComboBox<>();
        hpBar4 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lbHeroe1.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe1);
        lbHeroe1.setBounds(0, 0, 190, 150);

        cbHeroe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe1ActionPerformed(evt);
            }
        });
        add(cbHeroe1);
        cbHeroe1.setBounds(0, 200, 190, 33);

        prueba.setFocusTraversalPolicyProvider(true);
        prueba.setMinimumSize(new java.awt.Dimension(48, 48));
        add(prueba);
        prueba.setBounds(113, 400, 48, 48);
        add(lbAnimacion);
        lbAnimacion.setBounds(830, 120, 160, 130);
        add(hpBar1);
        hpBar1.setBounds(0, 150, 190, 30);

        lbHeroe2.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe2);
        lbHeroe2.setBounds(210, 0, 190, 150);

        cbHeroe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe2ActionPerformed(evt);
            }
        });
        add(cbHeroe2);
        cbHeroe2.setBounds(210, 200, 190, 33);
        add(hpBar2);
        hpBar2.setBounds(210, 150, 190, 30);

        lbHeroe3.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe3);
        lbHeroe3.setBounds(420, 0, 190, 150);

        cbHeroe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe3ActionPerformed(evt);
            }
        });
        add(cbHeroe3);
        cbHeroe3.setBounds(420, 200, 190, 33);
        add(hpBar3);
        hpBar3.setBounds(420, 150, 190, 30);

        lbHeroe4.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe4);
        lbHeroe4.setBounds(630, 0, 190, 150);

        cbHeroe4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe4ActionPerformed(evt);
            }
        });
        add(cbHeroe4);
        cbHeroe4.setBounds(630, 200, 190, 33);
        add(hpBar4);
        hpBar4.setBounds(630, 150, 190, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton1.setText("LINK START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(300, 430, 510, 130);
    }// </editor-fold>//GEN-END:initComponents

    // Genera los movimientos del personaje que se selecciona
    
    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed
        
        heroe1 = ArrayListed.heroes.get(cbHeroe1.getSelectedIndex());
        lbHeroe1.setIcon(new ImageIcon(heroe1.getSprite().getCara()));

        heroeSelected = ArrayListed.heroes.get(cbHeroe1.getSelectedIndex());

        //heroeSelected.getKeyboard().setAnimation(new Animation("resources/Animaciones/slash3.png", lbAnimacion));
    }//GEN-LAST:event_cbHeroe1ActionPerformed

    private void cbHeroe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe2ActionPerformed
        
        heroe2 = ArrayListed.heroes.get(cbHeroe2.getSelectedIndex());
        lbHeroe2.setIcon(new ImageIcon(heroe2.getSprite().getCara()));
    }//GEN-LAST:event_cbHeroe2ActionPerformed

    private void cbHeroe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe3ActionPerformed
        
        heroe3 = ArrayListed.heroes.get(cbHeroe3.getSelectedIndex());
        lbHeroe3.setIcon(new ImageIcon(heroe3.getSprite().getCara()));
    }//GEN-LAST:event_cbHeroe3ActionPerformed

    private void cbHeroe4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe4ActionPerformed
        
        heroe4 = ArrayListed.heroes.get(cbHeroe4.getSelectedIndex());
        lbHeroe4.setIcon(new ImageIcon(heroe4.getSprite().getCara()));
    }//GEN-LAST:event_cbHeroe4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Game game = new Game(heroe1, heroe2, heroe3, heroe4);
        game.setVisible(true);
        Globals.Main.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JComboBox<String> cbHeroe2;
    private javax.swing.JComboBox<String> cbHeroe3;
    private javax.swing.JComboBox<String> cbHeroe4;
    private javax.swing.JProgressBar hpBar1;
    private javax.swing.JProgressBar hpBar2;
    private javax.swing.JProgressBar hpBar3;
    private javax.swing.JProgressBar hpBar4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbAnimacion;
    private javax.swing.JLabel lbHeroe1;
    private javax.swing.JLabel lbHeroe2;
    private javax.swing.JLabel lbHeroe3;
    private javax.swing.JLabel lbHeroe4;
    private static javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
