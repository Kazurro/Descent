package ingame;

import characters.Personaje;

public class Casilla {

    private Personaje habitante;
    private boolean ocupable;
    private String tipo;
    private final int tamaño = 32;
    private int x, y;
    private int nX, nY;
    
    private int numcasilla;
    
    public Casilla(String tipo) {
        this.tipo = tipo;
    }
    
    // Get's y Set's
    
    public Personaje getHabitante(){
        
        return habitante;
    }

    public int getNumcasilla() {
        return numcasilla;
    }

    public void setNumcasilla(int numcasilla) {
        this.numcasilla = numcasilla;
    }

    public void setHabitante(Personaje habitante) {
        this.habitante = habitante;
    }

    public int getnX() {
        return nX;
    }

    public int getnY() {
        return nY;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setPosicion(int x, int y) {
        this.nX = x;
        this.nY = y;
    }
    
    public void setCoordenadas(int x, int y){
        
        this.x = x;
        this.y = y;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupable() {
        return ocupable;
    }
    
    public int[] getTipo() {
        int[] posicion = new int[2];
        
        if (tipo.contains("A")){ // Agua
            
            ocupable = false;
            
            posicion[0] = 265;
            posicion[1] = 32;
            return posicion;
            
        } else if (tipo.contains("T")){ // Tierra (Centro, UpIzq, UpDer, DowIzq, DowDer)
            
            ocupable = true;
            
            switch(tipo){
                case "T0":
                    posicion[0] = 32;
                    posicion[1] = 32;
                    return posicion;                
                case "T1":
                    posicion[0] = 0;
                    posicion[1] = 0;
                    return posicion;
                case "T2":
                    posicion[0] = 64;
                    posicion[1] = 0;
                    return posicion;
                case "T3":
                    posicion[0] = 0;
                    posicion[1] = 64;
                    return posicion;
                case "T4":
                    posicion[0] = 64;
                    posicion[1] = 64;
                    return posicion;
            }
            
        } else if (tipo.contains("B")){ // Borde (Centro, ..., ...)
            
            ocupable = false;
            
            switch(tipo){
                case "B0":
                    posicion[0] = 32;
                    posicion[1] = 320;
                    return posicion;
                case "B3":
                    posicion[0] = 0;
                    posicion[1] = 320;
                    return posicion;
                case "B4":
                    posicion[0] = 64;
                    posicion[1] = 320;
                    return posicion;
            }
            
        } else if (tipo.contains("E")){ // Espejo Agua
            
            ocupable = false;
            
            switch(tipo){
                case "E0":
                    posicion[0] = 32;
                    posicion[1] = 352;
                    return posicion;
                case "E3":
                    posicion[0] = 0;
                    posicion[1] = 352;
                    return posicion;
                case "E4":
                    posicion[0] = 64;
                    posicion[1] = 352;
                    return posicion;
            }
            
        } else if (tipo.contains("F")){ // Fondo Agua
            
            ocupable = false;
            
            switch(tipo){
                case "F0":
                    posicion[0] = 32;
                    posicion[1] = 384;
                    return posicion;
                case "F3":
                    posicion[0] = 0;
                    posicion[1] = 384;
                    return posicion;
                case "F4":
                    posicion[0] = 64;
                    posicion[1] = 384;
                    return posicion;
            }
            
        } else if (tipo.contains("C")){ // Caverna Agua
            
            ocupable = false;
            
            switch(tipo){
                case "C0":
                    posicion[0] = 352;
                    posicion[1] = 64;
                    return posicion;
                case "C1":
                    posicion[0] = 320;
                    posicion[1] = 32;
                    return posicion;
                case "C2":
                    posicion[0] = 384;
                    posicion[1] = 32;
                    return posicion;
                case "C3":
                    posicion[0] = 320;
                    posicion[1] = 64;
                    return posicion;
                case "C4":
                    posicion[0] = 384;
                    posicion[1] = 64;
                    return posicion;
                case "C5":
                    posicion[0] = 352;
                    posicion[1] = 32;
                    return posicion;
            }
        }
        
        return null;
    }

    // To String

    @Override public String toString() {
        
        return "Casilla{" + "ocupable=" + ocupable + ", tipo=" + tipo + ", tama\u00f1o=" + tamaño + ", x=" + x + ", y=" + y + ", nX=" + nX + ", nY=" + nY + '}';
    }
}
