/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import java.sql.SQLException;
import java.util.List;
import logica.Medico;
import persistencia.DAO.MedicoDAO;
import persistencia.DAO.SedeDAO;
import persistencia.DAOFactory;
import presentacion.vistas.LoginView;

/**
 *
 * @author Andre Sarmiento
 */
public class Modelo {

    private LoginView ventanaLogin;

    private DAOFactory dbFactory;

    public Modelo() {
        ventanaLogin = getVentanaLogin();
        
        dbFactory = getDbFactory();
    }

    public void iniciar() throws SQLException {
        ventanaLogin.setVisible(true);
        
        MedicoDAO medicosDB = dbFactory.getMedicosDB();
        
        List medicos = medicosDB.consultar();
        
        System.out.println("!!!" + ((Medico)medicos.get(0)).getId());
        //System.out.println("!!!" + ((Medico)medicos.get(1)).getId());
        
        SedeDAO sedeDB = dbFactory.getSedeDAO();
    }

    public LoginView getVentanaLogin() {
        if (ventanaLogin == null) {
            ventanaLogin = new LoginView(this);
        }
        return ventanaLogin;
    }

    public DAOFactory getDbFactory() {
        if (dbFactory == null) {
            dbFactory = new DAOFactory();
        }
        return dbFactory;
    }

}
