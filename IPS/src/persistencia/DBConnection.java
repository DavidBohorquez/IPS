/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre Sarmiento
 */
public class DBConnection {

    private String url;
    private String user;
    private String password;

    protected Connection connect;

    public DBConnection() {
        url = "jdbc:postgresql://localhost:5432/EPS";
        user = "postgres";
        password = "postgres2019";
    }

    public Connection conectarDB() {
        try {
            connect = DriverManager.getConnection(url, user, password);
            connect.setAutoCommit(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos");
        }
        return connect;
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException localSQLException) {
        }
    }
}
