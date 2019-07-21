
import java.sql.SQLException;
import presentacion.modelo.Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andre Sarmiento
 */
public class Launcher {
    
    private  Modelo gestor;
    
    public Launcher() throws SQLException {
        gestor = new Modelo();
        gestor.iniciar();
    }
    
    public static void main(String[] args) throws SQLException {
        new Launcher();
    }
    
}
