/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Medico;
import logica.Sede;
import persistencia.DAO.ConsultorioDAO;
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

    private ArrayList<Sede> sedes;

    public Modelo() {
        ventanaLogin = getVentanaLogin();

        dbFactory = getDbFactory();
    }

    public void iniciar() throws SQLException {
        ventanaLogin.setVisible(true);

        MedicoDAO medicosDB = dbFactory.getMedicosDB();
        SedeDAO sedeDB = dbFactory.getSedeDAO();

        List medicos = medicosDB.consultar();

        System.out.println("!!!" + ((Medico) medicos.get(0)).getId());

        Sede sede = new Sede("Bosa");

        System.out.println("nombreSede: " + sede.getNombre());
        sedeDB.insertar(sede);
    }

    public void loadBranches() throws SQLException {
        SedeDAO sedesDB = dbFactory.getSedeDAO();
        ConsultorioDAO consultoriosDB = dbFactory.getConsultoriosDB();
        
        List sedes = sedesDB.consultar();

        for (int i = 0; i < sedes.size(); i++) {
            ((Sede) sedes.get(i)).setConsultorios(null);
        }
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
