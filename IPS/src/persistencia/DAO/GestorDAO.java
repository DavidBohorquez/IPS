/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import logica.Cliente;
import logica.Medico;
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

    /*
     Es la tabla de la primera vista que se refiere a las CITAS disponibles,
     es decir, a las CITAS con estado 'A' y null en el campo de id del Cliente, o, a
     las CITAS con estado 'C' y con nuemro de identificacion del Cliente.
     */
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

    /*
     Este método asigna una cita disoponible o cancelada al cliente que previamente
     realizó su login.
    
     El código comentariado se realizó para probar la actulización de una cita. Los dos últomos
     campos del String de la consulta arroja el estado de la CITA y el id de la CITA.
     */
    public void asignarCita(int idCita, String estadoCita, Cliente cliente) {
        /*String consulta = consultarCitasDisp();
         String [] data = consulta.split("/");
        
         System.out.println("DATA: " + data[data.length -1] + "--" +data[data.length - 2]);*/
        System.out.println(idCita + ":" + estadoCita + ":" + cliente.getId());

        try {
            PreparedStatement st = conectarDB().prepareStatement("UPDATE cita \n"
                    + "SET i_estado = ?,\n"
                    + "    k_id_cliente = ?\n"
                    + "WHERE k_id = ?;");

            st.setString(1, estadoCita);
            st.setInt(2, cliente.getId());
            st.setInt(3, idCita);
            st.executeUpdate();
            st.close();
            connect.commit();
        } catch (SQLException ex) {
            System.err.println("CuentasDAO: error" + ex);
        }
        close();
    }

    @Override
    public List<Object> consultar() throws SQLException {
        List<Object> lista = null;

        return lista;
    }

    @Override
    public List<Object> consultarByName(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     El proposito es que crea una nueva agenda para un medico
     */
    public void insertarAgenda(Medico med, String fecha) {
        try {
            int agendaMaxima;

            PreparedStatement st = conectarDB().prepareStatement("select MAX(k_id) "
                    + "from agenda;");

            ResultSet rs = st.executeQuery();
            rs.next();
            agendaMaxima = rs.getInt(1);

            st = conectarDB().prepareStatement("INSERT INTO Agenda "
                    + "( k_id, f_fecha , i_estado , k_id_med) "
                    + "VALUES "
                    + "( " + (agendaMaxima + 1) + ", '" + fecha + "' ,  'A' , '" + med.getId() + "');");
            st.executeUpdate();

            rs.close();
            st.close();
            connect.commit();
        } catch (SQLException ex) {
            System.out.println("CuentasDAO: error" + ex);
        }
        close();
    }

    /*
     El proposito es que para la agenda que se le crea al medico, se le ponen
     automaticamente 3 citas
     */
    public void insertarCitasAgenda(Medico med) {
        try {
            int agendaMaxima;
            int citaMaxima;
            String esp = med.getEspecializacion();

            PreparedStatement st = conectarDB().prepareStatement("select MAX(k_id) "
                    + "from agenda;");

            ResultSet rs = st.executeQuery();
            rs.next();
            agendaMaxima = rs.getInt(1);

            for (int i = 1; i <= 3; i++) {
                st = conectarDB().prepareStatement("select MAX(k_id) "
                        + "from cita;");
                rs = st.executeQuery();
                rs.next();
                citaMaxima = rs.getInt(1);

                st = conectarDB().prepareStatement("INSERT INTO Cita "
                        + "( k_id,  i_estado , preescripcion , diagnostico , "
                        + "k_id_cliente, k_id_agenda, h_inicial , h_final , "
                        + "k_tipo_cita,k_id_multa )"
                        + "VALUES "
                        + "(" + (citaMaxima + 1) + ", 'A' , null, null, null, "
                        + "'" + agendaMaxima + "',TIME'" + med.gethIncial() + "',"
                        + "TIME'" + med.gethFinal() + "',"
                        + "'" + med.getEspecializacion() + "',null);");
                st.executeUpdate();
                rs.close();
                st.close();
                connect.commit();
            }

        } catch (SQLException ex) {
            System.out.println("CuentasDAO: error" + ex);
        }
        close();
    }

}
