package main;

public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();

        // Se auto añade a Globals (FullScreen y Icon App)
        Globals.setMain(Main.this);
        
        // Añade el panel Principal
        this.add(new Principal());
        
        // Añade al Background el fondo 1 a Full Screen
        Globals.setBackground(Globals.getPrincipal(), "resources/background1.jpg");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
