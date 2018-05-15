package main;

import static characters.Heroe.heroes;
import characters.Heroe;
import characters.Sprite;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import util.Keyboard;

public class newGame extends javax.swing.JPanel {
    
    private Keyboard keyboard;
    
    public newGame() {
        initComponents();
        Globals.setGame(this);
        this.setBounds(Globals.location);
        
        // Asesino
        new Heroe("Asesino", new Sprite("src/resources/sprites/heroes/asesino/"), 12, 5, 2, 4, 1);
        
        // Guerrero
        //new Heroe("Cleriga", new ImageIcon("src/resources/sprites/heroes/cleriga.gif"), 16, 2, 2,3, 2);
        new Heroe("Guerrero", new Sprite("src/resources/sprites/heroes/guerrero/"), 18, 4, 2,3, 1);
        //new Heroe("Luchador", new ImageIcon("src/resources/sprites/heroes/luchador.gif"), 16, 5, 2,3, 2);
        //new Heroe("Mago", new ImageIcon("src/resources/sprites/heroes/mago.gif"), 12, 4, 2,3, 3);
        //new Heroe("Paladin", new ImageIcon("src/resources/sprites/heroes/paladin.gif"), 18, 4, 2, 3, 1);
        setupComboBox(cbHeroe1);
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

        setMinimumSize(new java.awt.Dimension(1280, 720));

        lbHeroe1.setMinimumSize(new java.awt.Dimension(144, 144));

        cbHeroe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHeroe1ActionPerformed(evt);
            }
        });

        prueba.setMinimumSize(new java.awt.Dimension(48, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbHeroe1, 0, 190, Short.MAX_VALUE)
                    .addComponent(lbHeroe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(237, 237, 237)
                .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(729, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbHeroe1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbHeroe1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(464, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbHeroe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHeroe1ActionPerformed
        
        lbHeroe1.setIcon(new ImageIcon(heroes.get(cbHeroe1.getSelectedIndex()).getSprite().getCara()));
        keyboard = new Keyboard(prueba, heroes.get(cbHeroe1.getSelectedIndex()).getSprite());
    }//GEN-LAST:event_cbHeroe1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbHeroe1;
    private javax.swing.JLabel lbHeroe1;
    public javax.swing.JLabel prueba;
    // End of variables declaration//GEN-END:variables
}
