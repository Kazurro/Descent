package ingame;

import characters.Heroe;
import main.Globals;
import util.Eventos;

public class Game extends javax.swing.JFrame {

    private static Heroe heroe1;
    private static Heroe heroe2;
    private static Heroe heroe3;
    private static Heroe heroe4;
    private static int turno = 1;
    //Paneles
    private OvalPanel jP = new OvalPanel();
    private PanelFondo jF = new PanelFondo();
    
    public Game(Heroe heroe1, Heroe heroe2, Heroe heroe3, Heroe heroe4) {
        initComponents();
        
        // Carga el Frame a FullScreen
        this.setSize(Globals.fullScreen);
        Globals.Partida = this;
        PanelHeroes.setSize(Globals.fullScreen);
        
        // Carga el Mapa de fondo a FullScreen
        this.add(jP);
        this.add(jF);
        jP.setBounds(Globals.location);
        jF.setBounds(Globals.location);
        
        // Asigna los heroes seleccionados a sus respectivas JLabel
        this.heroe1 = heroe1;
        this.heroe2 = heroe2;
        this.heroe3 = heroe3;
        this.heroe4 = heroe4;
        
        // Asigna el primer turno al Heroe 1
        heroe1.getKeyboard().setLabel(lbHeroe1);
        heroe1.getGamePad().setGamePad(lbHeroe1);
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

        // Gestiona el turno de turno (Heroe actual, Heroe siguiente, JLabel de heroe siguiente)
        switch (turno) {
            case 1: Eventos.pasarTurno(heroe1, heroe2, lbHeroe2); turno += 1; break;
            case 2: Eventos.pasarTurno(heroe2, heroe3, lbHeroe3); turno += 1; break;
            case 3: Eventos.pasarTurno(heroe3, heroe4, lbHeroe4); turno += 1; break;
            case 4: Eventos.pasarTurno(heroe4, heroe1, lbHeroe1); turno = 1; break;
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