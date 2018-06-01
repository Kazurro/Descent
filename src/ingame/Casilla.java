package ingame;

import java.sql.Array;

public class Casilla {

    private String tipo;

    public Casilla(String tipo) {
        this.tipo = tipo;
    }

    public int[] getTipo() {
        int[] posicion = new int[2];
        switch (tipo) {
            //AGUA
            case "A":
                posicion[0] = 265;
                posicion[1] = 32;
                return posicion;
                //TIERRA Centro,UPIz,UpDer,DowIz,DowDer
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
                //BORDE 
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
                //ESPEJO AGUA
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
                //FONDO AGUA
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
                //CAVERNA AGUA
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
        return null;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
