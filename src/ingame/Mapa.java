package ingame;

import java.util.ArrayList;

public class Mapa {
    
    private ArrayList<Casilla> casillas = new ArrayList<>();
    
    private int tamañoX = 0; // 1600 (50 * 32px) // 1650 (50 * 33px)
    private int tamañoY = 0; // 704  (22 * 32px) // 704 (22 * 33px)
    private int iniX = 160; //160 (32px) // 135 (33px)
    private int iniY = 188; //188 (32px) // 177 (33px)

    // Constructor
    
    public Mapa(int tamañoX, int tamañoY) {
        
        this.tamañoX = tamañoX;
        this.tamañoY = tamañoY;
    }
    
    // Set's y Get's

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    
    public int getTamañoX() {
        return tamañoX;
    }

    public int getTamañoY() {
        return tamañoY;
    }

    public int getIniX() {
        return iniX;
    }

    public void setIniX(int iniX) {
        this.iniX = iniX;
    }

    public int getIniY() {
        return iniY;
    }

    public void setIniY(int iniY) {
        this.iniY = iniY;
    }
    
}
