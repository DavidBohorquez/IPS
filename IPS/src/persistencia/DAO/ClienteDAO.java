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
import logica.Categoria;
import logica.Cliente;
import persistencia.DBConnection;

/**
 *
 * @author David Bohorquez
 */
public class ClienteDAO extends DBConnection implements DAO {

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
        List<Object> lista = null;
        

        try {
            PreparedStatement st = conectarDB().prepareStatement("select *, per.k_id as id "
                    + "from persona per, cliente cli, categoria cat "
                    + "where per.k_id = cli.k_id "
                    + "and cli.k_categoria = cat.k_tipo;");

            ResultSet rs = st.executeQuery();

            lista = new ArrayList<Object>();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        new Categoria(
                                rs.getString("k_tipo").charAt(0),
                                rs.getInt("v_copago"), 
                                rs.getInt("v_multa")));
                
                cliente.setId(rs.getInt("id"));
                cliente.setTipoId(rs.getString("i_tipo_id"));
                cliente.setSexo(rs.getString("i_sexo"));
                cliente.setFechaNacimiento(rs.getDate("f_nacimiento"));
                cliente.setCorreo(rs.getString("n_correo"));
                cliente.setTelefono(rs.getString("tel_contacto"));
                cliente.setPassword(rs.getString("password"));
                cliente.getNombre()[0] = rs.getString("n_nombre");
                cliente.getNombre()[1] = rs.getString("n_apellido");
                cliente.setEstado(rs.getString("i_estado"));
                cliente.setParentesco(rs.getString("k_parentesco"));
                cliente.setEstadoMulta(rs.getString("estado_multa"));
                lista.add(cliente);
                System.out.println(cliente.getId());
                System.out.println(cliente.getCorreo());
                System.out.println(cliente.getCategoria().getTipo());
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
