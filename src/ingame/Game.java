package ingame;

import characters.Heroe;
import main.Globals;

public class Game extends javax.swing.JFrame {

    private static Heroe heroe1;
    private static Heroe heroe2;
    private static Heroe heroe3;
    private static Heroe heroe4;
    private static int cambio = 1;
    //Paneles
    private OvalPanel jP = new OvalPanel();
    private PanelFondo jF = new PanelFondo();
    
    public Game(Heroe heroe1, Heroe heroe2, Heroe heroe3, Heroe heroe4) {
        initComponents();
        
        this.add(jP);
        this.add(jF);
        
        PanelHeroes.setSize(Globals.fullScreen);

        this.setSize(Globals.fullScreen);
        Globals.Partida = this;

        this.heroe1 = heroe1;
        this.heroe2 = heroe2;
        this.heroe3 = heroe3;
        this.heroe4 = heroe4;
        
        // Carga los heroes

        heroe1.getKeyboard().setLabel(lbHeroe1);
        heroe1.getGamePad().setGamePad(lbHeroe1);

        jP.setBounds(Globals.location);
        jF.setBounds(Globals.location);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelHeroes = new javax.swing.JPanel();
        lbHeroe4 = new javax.swing.JLabel();
        lbHeroe3 = new javax.swing.JLabel();
        lbHeroe2 = new javax.swing.JLabel();
        lbHeroe1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(null);

        PanelHeroes.setOpaque(false);
        PanelHeroes.setLayout(null);
        PanelHeroes.add(lbHeroe4);
        lbHeroe4.setBounds(76, 614, 74, 74);
        PanelHeroes.add(lbHeroe3);
        lbHeroe3.setBounds(76, 442, 74, 74);
        PanelHeroes.add(lbHeroe2);
        lbHeroe2.setBounds(76, 270, 74, 74);
        PanelHeroes.add(lbHeroe1);
        lbHeroe1.setBounds(76, 98, 74, 74);

        jButton1.setText("Pasar Turno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelHeroes.add(jButton1);
        jButton1.setBounds(690, 40, 230, 60);

        getContentPane().add(PanelHeroes);
        PanelHeroes.setBounds(110, 10, 1010, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        switch (cambio) {
            case 1:
                heroe1.getKeyboard().transferListener();
                heroe1.getGamePad().transferListener();
                heroe2.getGamePad().setGamePad(lbHeroe2);
                heroe2.getKeyboard().setLabel(lbHeroe2);
                lbHeroe2.transferFocus();
                cambio += 1;
                break;
            case 2:
                heroe2.getKeyboard().transferListener();
                heroe2.getGamePad().transferListener();
                heroe3.getGamePad().setGamePad(lbHeroe3);
                heroe3.getKeyboard().setLabel(lbHeroe3);
                lbHeroe3.transferFocus();
                cambio += 1;
                break;
            case 3:
                heroe3.getKeyboard().transferListener();
                heroe3.getGamePad().transferListener();
                heroe4.getGamePad().setGamePad(lbHeroe4);
                heroe4.getKeyboard().setLabel(lbHeroe4);
                lbHeroe4.transferFocus();
                cambio += 1;
                break;
            case 4:
                heroe4.getKeyboard().transferListener();
                heroe4.getGamePad().transferListener();
                heroe1.getGamePad().setGamePad(lbHeroe1);
                heroe1.getKeyboard().setLabel(lbHeroe1);
                lbHeroe1.transferFocus();
                cambio = 1;
                break;
            default: break;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Game(heroe1, heroe2, heroe3, heroe4).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelHeroes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbHeroe1;
    private javax.swing.JLabel lbHeroe2;
    private javax.swing.JLabel lbHeroe3;
    private javax.swing.JLabel lbHeroe4;
    // End of variables declaration//GEN-END:variables
}
