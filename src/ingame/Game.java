package ingame;

import characters.ArrayListed;
import characters.Heroe;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import main.Globals;

public class Game extends javax.swing.JFrame {

    private static Heroe heroe1;
    private static Heroe heroe2;
    private static Heroe heroe3;
    private static Heroe heroe4;
    private static int cambio = 1;
    //Paneles
    public static OvalPanel jP = new OvalPanel();
    public static PanelFondo jF = new PanelFondo();

    GridBagLayout layout = new GridBagLayout();

    public Game(Heroe heroe1, Heroe heroe2, Heroe heroe3, Heroe heroe4) {
        initComponents();
        // Agregamos paneles
        ContenedorMapa.setLayout(layout);
        ContenedorMapa.add(jP);
        ContenedorMapa.add(jF);
        ContenedorMapa.setSize(Globals.fullScreen);
        ContenedorMapa.setPreferredSize(Globals.fullScreen);
        

        PanelHeroes.setBackground(new Color(0, 0, 0, 0));
        PanelHeroes.setSize(Globals.fullScreen);
        PanelHeroes.setPreferredSize(Globals.fullScreen);

        this.setSize(Globals.fullScreen);
        Globals.Partida = this;

        this.heroe1 = heroe1;
        this.heroe2 = heroe2;
        this.heroe3 = heroe3;
        this.heroe4 = heroe4;
        
//      // Carga los heroes

        try {
            heroe1.getKeyboard().transferListener();
            heroe1.getGamePad().transferListener();

        } catch (Exception except) {
        }

        heroe1.getKeyboard().setLabel(lbHeroe1);
        heroe1.getGamePad().setGamePad(lbHeroe1);
        //heroe2.getKeyboard().setLabel(lbHeroe2);
        //heroe3.getKeyboard().setLabel(lbHeroe1);
        //heroe4.getKeyboard().setLabel(lbHeroe1);

        // Carga el mapa de la partida en un JLabel situado detras de todo
//        this.add(Globals.addBackground(new JLabel()));
//        Globals.setBackground(Globals.fullScreen, "resources/mapa1.jpg");
//        Globals.getBackground().setVisible(true);
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
        ContenedorMapa = new javax.swing.JPanel();

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

        javax.swing.GroupLayout ContenedorMapaLayout = new javax.swing.GroupLayout(ContenedorMapa);
        ContenedorMapa.setLayout(ContenedorMapaLayout);
        ContenedorMapaLayout.setHorizontalGroup(
            ContenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        ContenedorMapaLayout.setVerticalGroup(
            ContenedorMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        getContentPane().add(ContenedorMapa);
        ContenedorMapa.setBounds(0, 0, 1060, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jP.setBounds(Globals.location);
        jP.setVisible(true);
        jF.setBounds(Globals.location);
        jF.setVisible(true);

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
            default:
                break;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Game(heroe1, heroe2, heroe3, heroe4).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel ContenedorMapa;
    public static javax.swing.JPanel PanelHeroes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbHeroe1;
    private javax.swing.JLabel lbHeroe2;
    private javax.swing.JLabel lbHeroe3;
    private javax.swing.JLabel lbHeroe4;
    // End of variables declaration//GEN-END:variables
}
