package main;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class License extends javax.swing.JPanel {

    public License() {
        initComponents();
        
        Globals.setLicencia(this);
        this.setBounds(Globals.location);
        this.setBackground(new Color(0, 0, 0, 50));
                
        // Ajusto los elementos para centrarlos en la pantalla Full Screen
        
        lbCompanyLogo.setLocation((this.getWidth() / 2) - (lbCompanyLogo.getWidth() / 2),
                                  (this.getHeight() / 2) - (lbCompanyLogo.getHeight() / 2));
        
        lbExit.addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                
                Globals.getLicencia().setVisible(false);
                Globals.setBackground(Globals.fullScreen, "src/resources/background1.jpg");
                Globals.getBackground().setVisible(true);
                Globals.getPrincipal().setVisible(true);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbExit = new javax.swing.JLabel();
        lbCompanyLogo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName("3"); // NOI18N

        lbExit.setBackground(new java.awt.Color(255, 255, 255));
        lbExit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbExit.setText("Volver");

        lbCompanyLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/companyLogo.png"))); // NOI18N
        lbCompanyLogo.setText("jLabel1");
        lbCompanyLogo.setMinimumSize(new java.awt.Dimension(631, 111));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(lbCompanyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(lbCompanyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbCompanyLogo;
    private javax.swing.JLabel lbExit;
    // End of variables declaration//GEN-END:variables
}
