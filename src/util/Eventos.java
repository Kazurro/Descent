package util;

import characters.Heroe;
import javax.swing.JLabel;

public class Eventos {
    
    // Gestiona el turno de turno (Heroe actual, Heroe siguiente, JLabel de heroe siguiente)
    
    public static void pasarTurno(Heroe heroe1, Heroe heroe2, JLabel heroeFocus) {
        
        heroe1.getKeyboard().transferListener();
        heroe1.getGamePad().transferListener();
        heroe2.getGamePad().setGamePad(heroeFocus);
        heroe2.getKeyboard().setLabel(heroeFocus);
        heroeFocus.transferFocus();
    }
}
