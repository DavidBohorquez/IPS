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
import logica.Consultorio;
import logica.Sede;
import persistencia.DBConnection;

/**
 *
 * @author Andre Sarmiento
 */
public class ConsultorioDAO extends DBConnection implements DAO {

    @Override
    public void insertar(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        List<Object> lista = null;

        try {
            PreparedStatement st = conectarDB().prepareStatement("SELECT * FROM consultorio WHERE n_sede = ?");

            st.setString(1, ((Sede) objeto).getNombre());

            ResultSet rs = st.executeQuery();

            lista = new ArrayList<Object>();

            while (rs.next()) {
                Consultorio consultorio = new Consultorio((Sede) objeto);

                consultorio.setNumero(rs.getString("k_numero"));
                consultorio.getSede().setNombre(rs.getString("n_sede"));
                consultorio.setTipo(rs.getString("tipo"));
                consultorio.setDesc(rs.getString("descp_equipo"));
                //Médicos
                consultorio.setFranja(rs.getTime("franja"));

                lista.add(consultorio);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("ConsultorioDAO: error");
        }
        close();

        return lista;
    }

}
