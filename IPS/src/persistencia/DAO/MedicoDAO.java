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
            PreparedStatement st = conectarDB().prepareStatement("INSERT INTO doctor (k_id, i_tipo_id, i_sexo, f_nacimiento, "
                    + "n_correo, tel_contacto, password, n_nombre, n_apellido, k_id, k_cod_esp) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            st.setInt(1, ((Medico) objeto).getId());
            st.setString(2, ((Medico) objeto).getTipoId());
            st.setString(3, ((Medico) objeto).getNombre()[0]);
            st.setString(4, ((Medico) objeto).getNombre()[1]);
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
            PreparedStatement st = conectarDB().prepareStatement("SELECT *, per.k_id as id "
                    + "FROM persona per, doctor doc "
                    + "WHERE per.k_id = doc.k_id;");

            ResultSet rs = st.executeQuery();

            lista = new ArrayList<Object>();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setTipoId(rs.getString("i_tipo_id"));
                medico.setSexo(rs.getString("i_sexo"));
                medico.setFechaNacimiento(rs.getDate("f_nacimiento"));
                medico.setCorreo(rs.getString("n_correo"));
                medico.setTelefono(rs.getString("tel_contacto"));
                medico.setPassword(rs.getString("password"));
                medico.getNombre()[0] = rs.getString("n_nombre");
                medico.getNombre()[1] = rs.getString("n_apellido");

                medico.setEspecializacion(rs.getString("k_cod_esp"));
                medico.sethIncial(rs.getTime("h_inicial"));
                medico.sethFinal(rs.getTime("h_final"));
                medico.setSede(rs.getString("k_sede"));
                medico.setAgenda(rs.getString("i_agenda"));

                lista.add(medico);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("CuentasDAO: error" + ex);
        }
        close();

        return lista;
    }

    @Override
    public List<Object> consultarByName(Object objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
