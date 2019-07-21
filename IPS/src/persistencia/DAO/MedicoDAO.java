/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Medico;
import persistencia.DBConnection;

/**
 *
 * @author Andre Sarmiento
 */
public class MedicoDAO extends DBConnection implements DAO {

    @Override
    public void insertar(Object objeto) throws SQLException {
        try {
            PreparedStatement st = conectarDB().prepareStatement("insert into medicos (nombre) values (?)");

            st.setString(1, ((Medico) objeto).getNombre()[0]);
            st.executeUpdate();
            st.close();

        } catch (SQLException ex) {
            System.out.println("MedicoDAO: error");
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
        List<Object> lista = null;

        try {
            PreparedStatement st = conectarDB().prepareStatement("select * from doctor");

            ResultSet rs = st.executeQuery();

            lista = new ArrayList<Object>();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getString("k_id"));

                lista.add(medico);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("CuentasDAO: error");
        }
        close();

        return lista;
    }

    @Override
    public List<Object> consultarByName(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
