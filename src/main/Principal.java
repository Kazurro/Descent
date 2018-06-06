package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends javax.swing.JPanel {

    public Principal() {
        initComponents();
        
        // Se auto añade a Globals (FullScreen y Background transparente)
        Globals.setPrincipal(Principal.this);
        
        // Abre la ventana de selección de personaje
        lbNewGame.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { 
               
                Globals.getPrincipal().setVisible(false);
                Globals.Main.add(new newGame());
            }
        });
        
        // Cierra la aplicación completamente
        lbExit.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                
                System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBrand = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        lbOptions = new javax.swing.JLabel();
        lbLoadGame = new javax.swing.JLabel();
        lbNewGame = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        lbBrand.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kazuto\\Documents\\NetBeansProjects\\Descent\\resources\\brand.png")); // NOI18N

        lbExit.setBackground(new java.awt.Color(255, 255, 255));
        lbExit.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        lbExit.setForeground(new java.awt.Color(255, 255, 255));
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbExit.setText("Salir");

        lbOptions.setBackground(new java.awt.Color(255, 255, 255));
        lbOptions.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        lbOptions.setForeground(new java.awt.Color(255, 255, 255));
        lbOptions.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbOptions.setText("Opciones");

        lbLoadGame.setBackground(new java.awt.Color(255, 255, 255));
        lbLoadGame.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        lbLoadGame.setForeground(new java.awt.Color(255, 255, 255));
        lbLoadGame.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLoadGame.setText("Continuar");

        lbNewGame.setBackground(new java.awt.Color(255, 255, 255));
        lbNewGame.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        lbNewGame.setForeground(new java.awt.Color(255, 255, 255));
        lbNewGame.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNewGame.setText("Partida nueva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(969, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbExit)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbLoadGame)
                                    .addComponent(lbNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 707, Short.MAX_VALUE)
                        .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(lbNewGame)
                .addGap(18, 18, 18)
                .addComponent(lbLoadGame)
                .addGap(18, 18, 18)
                .addComponent(lbOptions)
                .addGap(18, 18, 18)
                .addComponent(lbExit)
                .addGap(167, 167, 167))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbLoadGame;
    private javax.swing.JLabel lbNewGame;
    private javax.swing.JLabel lbOptions;
    // End of variables declaration//GEN-END:variables
}
