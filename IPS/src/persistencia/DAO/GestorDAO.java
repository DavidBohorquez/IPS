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
import logica.Cliente;
import persistencia.DBConnection;

/**
 *
 * @author Andre Sarmiento
 */
public class GestorDAO extends DBConnection implements DAO {

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

    public String consultarCitasDisp() {
        String consulta = "";

        try {
            PreparedStatement st = conectarDB().prepareStatement("SELECT CONCAT(CONCAT(CONCAT(CONCAT(s.k_nombre, ' '), c.k_numero), ' - '), s.direccion) AS lugar,\n"
                    + "	ci.k_tipo_cita AS tipoCita,\n"
                    + "	CONCAT(CONCAT(p.n_nombre, ' '), p.n_apellido) AS nombreMedico,\n"
                    + "	TO_CHAR(a.f_fecha, 'DD-MON-YYYY') AS fecha ,\n"
                    + "	TO_CHAR(ci.h_final, 'HH24') AS hora,\n"
                    + "	ci.i_estado AS estado,\n"
                    + "	ci.k_id AS idCita\n"
                    + "FROM sede s, consultorio c, cita ci, doctor m, agenda a, persona p\n"
                    + "WHERE s.k_nombre = c.k_n_sede\n"
                    + "AND	c.k_numero = m.k_consultorio\n"
                    + "AND	m.k_id = a.k_id_med\n"
                    + "AND	a.k_id = ci.k_id_agenda\n"
                    + "AND	p.k_id = m.k_id\n"
                    + "AND	((ci.i_estado = 'A' AND ci.k_id_cliente is null) \n"
                    + "	OR (ci.i_estado = 'C'))");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                consulta += rs.getString("lugar") + "/";
                consulta += rs.getString("tipoCita") + "/";
                consulta += rs.getString("nombreMedico") + "/";
                consulta += rs.getString("fecha") + "/";
                consulta += rs.getString("hora") + "/";
                consulta += rs.getString("estado") + "/";
                consulta += rs.getInt("idCita");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.err.println("CuentasDAO: error" + ex);
        }
        close();

        return consulta;
    }

    public void asignarCita(String idCita, Cliente cliente) {
        /*try {
         PreparedStatement st = conectarDB().prepareStatement("UPDATE cita \n"
         + "SET i_estado = ?,\n"
         + "    k_id_cliente = ?\n"
         + "WHERE k_id = ?;");

         st.setString(1, idCita);
         st.setString(2, cliente.);
         st.executeUpdate();
         st.close();

         } catch (SQLException ex) {
         System.out.println("CuentasDAO: error");
         }
         close();*/
    }

    @Override
    public List<Object> consultar() throws SQLException {
        List<Object> lista = null;

        return lista;
    }

    @Override
    public List<Object> consultarByName(Object objeto) throws SQLException {
        List<Object> lista = null;

        /*try {
         PreparedStatement st = conectarDB().prepareStatement("select * from transacciones where cuenta = ?");

         st.setString(1, ((Cuenta) objeto).getNombre());

         ResultSet rs = st.executeQuery();

         lista = new ArrayList<Object>();

         while (rs.next()) {
         Transaccion trans = new Transaccion((Cuenta) objeto);

         trans.setId(rs.getString("id"));
         trans.getCategoria().setTipo(rs.getString("tipo"));
         trans.getCategoria().setNombre(rs.getString("categoria"));
         trans.setValor(rs.getFloat("valor"));
         trans.setFecha(rs.getString("fecha"));

         lista.add(trans);
         }
         rs.close();
         st.close();
         } catch (SQLException ex) {
         System.out.println("TransDAO: error");
         }
         close();
         */
        return lista;
    }

}
