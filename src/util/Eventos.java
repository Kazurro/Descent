package util;

import characters.Heroe;
import javax.swing.JLabel;

public class Eventos {
    
    public static void pasarTurno(Heroe heroe1, Heroe heroe2, JLabel heroeFocus) {
        
        heroe1.getKeyboard().transferListener();
        heroe1.getGamePad().transferListener();
        heroe2.getGamePad().setGamePad(heroeFocus);
        heroe2.getKeyboard().setLabel(heroeFocus);
        heroeFocus.transferFocus();
    }
}
