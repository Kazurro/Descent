package main;

import characters.ArrayListed;
import characters.Heroe;
import util.Animation;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import util.ConexionBBDD;
import util.Gamepad;

public class newGame extends javax.swing.JPanel {
    
    ConexionBBDD conexion; 
    //private Keyboard keyboard;
    private Gamepad heroe1;
    private Animation animacion;
    private Heroe heroeSelected;
    
    public newGame() {
        initComponents();
        Globals.setGame(this);
        this.setBounds(Globals.location);
        
        // Genero una nueva conexión
        
        try {
            conexion = new ConexionBBDD("C:/Descent/BBDD.db");
            conexion.cargarHeroes();
            setupComboBox(cbHeroe1);
        } catch (SQLException ex) {}

        // Carga el mapa de la partida en un JLabel situado detras de todo
        
        this.add(Globals.addBackground(new JLabel()));
        Globals.setBackground(Globals.fullScreen, "resources/mapa1.jpg");//new Color(0, 0, 0, 0));
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

    // Genera los movimientos del personaje que se selecciona
    
    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed
        prueba.setIcon(null); prueba.repaint();
        try {
            heroeSelected.getKeyboard().transferListener();
        } catch(Exception except){}
        
        heroeSelected = ArrayListed.heroes.get(cbHeroe1.getSelectedIndex());
        
        // Muestro cara del Heroe seleccionado
        lbHeroe1.setIcon(new ImageIcon(heroeSelected.getSprite().getCara()));
        
        // Inicializo los movimientos y animaciones del Heroe selecionado
        heroeSelected.getKeyboard().setLabel(this.prueba);
        this.prueba.transferFocus();
        //keyboard = new Keyboard(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
        
        
        heroeSelected.getKeyboard().setAnimation(new Animation("resources/Animaciones/slash3.png", lbAnimacion));
        //heroe1 = new Gamepad(this.prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
    }//GEN-LAST:event_cbHeroe1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JLabel lbAnimacion;
    private javax.swing.JLabel lbHeroe1;
    private static javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
