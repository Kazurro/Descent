package main;

import characters.ArrayListed;
import characters.Heroe;
import ingame.Game;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import util.ConexionBBDD;

public class newGame extends javax.swing.JPanel {

    private ConexionBBDD conexion;
    private Heroe heroe1;
    private Heroe heroe2;
    private Heroe heroe3;
    private Heroe heroe4;

    public newGame() {
        initComponents();
        Globals.setGame(this);
        this.setBounds(Globals.location);

        // Posición del botón Volver
        lbReturn.setBounds(Globals.location.width - 200, Globals.location.height - 200, 110, 60);

        // Genero una nueva conexión
        try {
            conexion = new ConexionBBDD("BBDD.db");
            conexion.cargarHeroes();
            
            setupComboBox(cbHeroe1);
            setupComboBox(cbHeroe2);
            setupComboBox(cbHeroe3);
            setupComboBox(cbHeroe4);
        } catch (SQLException ex) {
        }

        // Carga el fondo de selección de Heroe
        Globals.getBackground().setVisible(false);
        this.add(Globals.addBackground(new JLabel()));
        Globals.setBackground(Globals.fullScreen, "resources/background2.jpg");
        Globals.getBackground().setVisible(true);

        // Botón Volver
        lbReturn.addMouseListener(new MouseAdapter() {
            
            @Override public void mouseClicked(MouseEvent e) {

                newGame.this.setVisible(false);
                Globals.getPrincipal().setVisible(true);
                Globals.Main.add(Globals.addBackground(new JLabel()));
                Globals.setBackground(Globals.fullScreen, "resources/background1.jpg");
                Globals.Main.repaint();
            }
        });

    }

    static ArrayList<Heroe> relHeroes = new ArrayList<>();
    static ArrayList<String> selHeroes = new ArrayList<>();
    // Carga los heroes en el ComboBox
    public static void setupComboBox(JComboBox seleccion) {
        
        ArrayListed.heroes.forEach((heroe) -> {
            selHeroes.add(heroe.getNombre());

        });

        relHeroes = ArrayListed.heroes;
        seleccion.setModel(new DefaultComboBoxModel(selHeroes.toArray()));
    }

    //Recarga los heroes del ComboBox
    public static void reCB(JComboBox seleccion) {
        selHeroes.clear();
        
        relHeroes.forEach((heroe) -> {
            selHeroes.add(heroe.getNombre());

        });
        
        seleccion.setModel(new DefaultComboBoxModel(selHeroes.toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbReturn = new javax.swing.JLabel();
        lbHeroe1 = new javax.swing.JLabel();
        cbHeroe1 = new javax.swing.JComboBox<>();
        lbHeroe2 = new javax.swing.JLabel();
        cbHeroe2 = new javax.swing.JComboBox<>();
        lbHeroe3 = new javax.swing.JLabel();
        cbHeroe3 = new javax.swing.JComboBox<>();
        lbHeroe4 = new javax.swing.JLabel();
        cbHeroe4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lbReturn.setBackground(new java.awt.Color(255, 255, 255));
        lbReturn.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        lbReturn.setForeground(new java.awt.Color(255, 255, 255));
        lbReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbReturn.setText("Volver");
        add(lbReturn);
        lbReturn.setBounds(1150, 640, 110, 51);

        lbHeroe1.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe1);
        lbHeroe1.setBounds(300, 80, 190, 150);

        cbHeroe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe1ActionPerformed(evt);
            }
        });
        add(cbHeroe1);
        cbHeroe1.setBounds(300, 280, 190, 33);

        lbHeroe2.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe2);
        lbHeroe2.setBounds(510, 80, 190, 150);

        cbHeroe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe2ActionPerformed(evt);
            }
        });
        add(cbHeroe2);
        cbHeroe2.setBounds(510, 280, 190, 33);

        lbHeroe3.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe3);
        lbHeroe3.setBounds(720, 80, 190, 150);

        cbHeroe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe3ActionPerformed(evt);
            }
        });
        add(cbHeroe3);
        cbHeroe3.setBounds(730, 280, 190, 33);

        lbHeroe4.setMinimumSize(new java.awt.Dimension(144, 144));
        add(lbHeroe4);
        lbHeroe4.setBounds(930, 80, 190, 150);

        cbHeroe4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe4ActionPerformed(evt);
            }
        });
        add(cbHeroe4);
        cbHeroe4.setBounds(930, 280, 190, 33);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton1.setText("LINK START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(470, 410, 510, 130);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Game game = new Game(heroe1, heroe2, heroe3, heroe4);
        game.setVisible(true);
        Globals.Main.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbHeroe4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe4ActionPerformed
        cbHeroe4.setEnabled(false);
        heroe4 = relHeroes.get(cbHeroe4.getSelectedIndex());
        lbHeroe4.setIcon(new ImageIcon(heroe4.getSprite().getCara()));

        // Funcion para remover un heroe y recargar las tablas
        relHeroes.remove(cbHeroe4.getSelectedIndex());
        newGame.reCB(cbHeroe1);
        newGame.reCB(cbHeroe2);
        newGame.reCB(cbHeroe3);
    }//GEN-LAST:event_cbHeroe4ActionPerformed

    private void cbHeroe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe3ActionPerformed

        cbHeroe3.setEnabled(false);
        heroe3 = relHeroes.get(cbHeroe3.getSelectedIndex());
        lbHeroe3.setIcon(new ImageIcon(heroe3.getSprite().getCara()));
        relHeroes.remove(cbHeroe3.getSelectedIndex());
        newGame.reCB(cbHeroe1);
        newGame.reCB(cbHeroe2);
        newGame.reCB(cbHeroe4);
    }//GEN-LAST:event_cbHeroe3ActionPerformed

    private void cbHeroe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe2ActionPerformed

        cbHeroe2.setEnabled(false);
        heroe2 = relHeroes.get(cbHeroe2.getSelectedIndex());
        lbHeroe2.setIcon(new ImageIcon(heroe2.getSprite().getCara()));
        relHeroes.remove(cbHeroe2.getSelectedIndex());
        newGame.reCB(cbHeroe1);
        newGame.reCB(cbHeroe4);
        newGame.reCB(cbHeroe3);
    }//GEN-LAST:event_cbHeroe2ActionPerformed

    // Genera los movimientos del personaje que se selecciona

    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed

        cbHeroe1.setEnabled(false);
        heroe1 = relHeroes.get(cbHeroe1.getSelectedIndex());
        lbHeroe1.setIcon(new ImageIcon(heroe1.getSprite().getCara()));
        relHeroes.remove(cbHeroe1.getSelectedIndex());
        newGame.reCB(cbHeroe4);
        newGame.reCB(cbHeroe2);
        newGame.reCB(cbHeroe3);
        //heroeSelected.getKeyboard().setAnimation(new Animation("resources/Animaciones/slash3.png", lbAnimacion));
    }//GEN-LAST:event_cbHeroe1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JComboBox<String> cbHeroe2;
    private javax.swing.JComboBox<String> cbHeroe3;
    private javax.swing.JComboBox<String> cbHeroe4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbHeroe1;
    private javax.swing.JLabel lbHeroe2;
    private javax.swing.JLabel lbHeroe3;
    private javax.swing.JLabel lbHeroe4;
    private javax.swing.JLabel lbReturn;
    // End of variables declaration//GEN-END:variables
}
