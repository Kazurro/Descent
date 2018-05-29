package util;

import characters.Heroe;
import characters.Sprite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBBDD {
    
    private final Connection conexion;
    private final Statement prep;
    private ResultSet consulta;
    
    public ConexionBBDD(String ruta) throws SQLException {
        
        conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
        prep = conexion.createStatement();
    }
    
    public void Query(int modo, String nombreTabla, String condicion){

        try {
            switch(modo){
                case 1: consulta = prep.executeQuery("SELECT * FROM " + nombreTabla + ";"); break;
                case 2: prep.executeUpdate("INSERT INTO " + nombreTabla + " " + condicion); break;
                case 3: prep.executeUpdate("UPDATE " + nombreTabla + " " + condicion); break;
                case 4: prep.executeUpdate("DELETE FROM " + nombreTabla + " " + condicion); break;
            }
            
        } catch (SQLException ex) {}
    }
    
    public void cargarHeroes(){
        
        this.Query(1, "HEROES", "");
        
        try {
            while(consulta.next()){
                
                new Heroe(consulta.getString(2), new Sprite(consulta.getString(3)),
                            consulta.getInt(4), consulta.getInt(5), consulta.getInt(6),
                            consulta.getInt(7), consulta.getInt(8));
            }
        } catch (SQLException ex) {}
    }
}
