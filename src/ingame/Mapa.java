package ingame;

import java.util.ArrayList;

public class Mapa {
    
    private ArrayList<Casilla> casillas = new ArrayList<>();
    
    private int tamañoX = 1600; // 1600 (50 * 32px) //1650 (50 * 33px)
    private int tamañoY = 704;  // 704  (22 * 32px) // 704 (22 * 33px)

    // Constructor
    
    public Mapa() {
        
    }
    
    // Set's y Get's

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    public int getTamañoX() {
        return tamañoX;
    }

    public void setTamañoX(int tamañoX) {
        this.tamañoX = tamañoX;
    }

    public int getTamañoY() {
        return tamañoY;
    }

    public void setTamañoY(int tamañoY) {
        this.tamañoY = tamañoY;
    }

    
}
