package characters;

import items.Arma;
import items.Armadura;
import javax.swing.ImageIcon;

public class Heroe extends Generic {
    
    private Arma arma;
    private Armadura armadura;
    
    public Heroe(String nombre, ImageIcon imagen, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, imagen, vida, daño, defensa, movimiento, rango);
    }
    
    public void equiparArma() {
        super.setDaño(arma.getDaño());
        super.setMovimiento(-arma.getPeso());
        super.setRango(arma.getRango());
    }
    
    public void equiparArmadura() {
        super.setVida(armadura.getVida());
        super.setMovimiento(-armadura.getPeso());
        super.setDefensa(armadura.getDefensa());
    }
    
    public void desequiparArma() {
        super.setDaño(-arma.getDaño());
        super.setMovimiento(+arma.getPeso());
        super.setRango(-arma.getRango());
    }
    
    public void desequiparArmadura() {
        super.setVida(-armadura.getVida());
        super.setMovimiento(+armadura.getPeso());
        super.setDefensa(-armadura.getDefensa());
    }
}
