package characters;

import items.Arma;
import items.Armadura;
import java.util.ArrayList;

public class Heroe extends Generic {
    
    public static ArrayList<Heroe> heroes = new ArrayList<>();
    private Arma arma;
    private Armadura armadura;
    
    public Heroe(String nombre, Sprite sprite, int vida, int daño, int defensa, int movimiento, int rango) {
        super(nombre, sprite, vida, daño, defensa, movimiento, rango);
        
        heroes.add(this);
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
