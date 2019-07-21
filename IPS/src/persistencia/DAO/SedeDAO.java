/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import logica.Sede;
import persistencia.DBConnection;

/**
 *
 * @author Andre Sarmiento
 */
public class SedeDAO extends DBConnection implements DAO{

    @Override
    public void insertar(Object objeto) throws SQLException {
        try {
            PreparedStatement st = conectarDB().prepareStatement("insert into sede (nombre) values (?)");

            st.setString(1, ((Sede) objeto).getNombre());
            st.executeUpdate();
            st.close();

        } catch (SQLException ex) {
            System.out.println("SedeDAO: error");
        }
        close();
    }

    @Override
    public void modificar(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> consultarByName(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
