package main;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;

public class GamePadExample extends javax.swing.JFrame {

    private XboxController xc;
    private int y = 330;
    private int x = 505;
    
    public GamePadExample() {
        initComponents();
        
        xc = new XboxController();
        xc.setLeftThumbDeadZone(0);
        if (!xc.isConnected()){
            xc.release();
            return;
        }
    
        xc.addXboxControllerListener(new XboxControllerAdapter(){
            
            public void dpad(int direction, boolean pressed){
                        
                    switch(direction){
                        case 0: y -= 30; break;
                        case 1: y -= 30; x += 30; break;
                        case 2: x += 30; break;
                        case 3: y += 30; x += 30; break;
                        case 4: y += 30; break;
                        case 5: y += 30; x -= 30; break;
                        case 6: x -= 30; break;
                        case 7: x -= 30; y -= 30; break;
                    }
                
                sprite.setLocation(x, y);
            }
   
            @Override public void leftThumbDirection(double direction) {
                
                if (direction > 315 && direction < 360|| direction > 0 && direction < 45) {
                    y -= 30;
                } else if (direction > 45 && direction < 135) {
                    x += 30;
                } else if (direction > 135 && direction < 225) {
                    y += 30;
                } else if (direction > 225 && direction < 315) {
                    x -= 30;
                }
                
                sprite.setLocation(x, y);
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sprite = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sprite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sprites/heroes/guerrero.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(sprite, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(sprite, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new GamePadExample().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel sprite;
    // End of variables declaration//GEN-END:variables
}
