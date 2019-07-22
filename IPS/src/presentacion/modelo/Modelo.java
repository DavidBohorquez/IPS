/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Cliente;
import logica.Medico;
import persistencia.DAO.ClienteDAO;
import persistencia.DAO.GestorDAO;
import persistencia.DAO.MedicoDAO;
import persistencia.DAOFactory;
import presentacion.vistas.LoginView;

/**
 *
 * @author Andre Sarmiento
 */
public class Modelo {

    private LoginView ventanaLogin;

    private DAOFactory dbFactory;

    private ArrayList<Medico> medicos;

    public Modelo() {
        ventanaLogin = getVentanaLogin();

        dbFactory = getDbFactory();
    }

    public void iniciar() throws SQLException {
        ventanaLogin.setVisible(true);

        MedicoDAO medicosDB = dbFactory.getMedicosDB();

        ClienteDAO clientesDB = dbFactory.getClientesDB();

        GestorDAO gestorDB = dbFactory.getGestorDB();

        List medicos = medicosDB.consultar();

        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(((Medico) medicos.get(i)).getNombre()[0]);
            System.out.println(((Medico) medicos.get(i)).getSede());
            System.out.println(((Medico) medicos.get(i)).getEspecializacion());
        }

        List clientes = clientesDB.consultar();

        System.out.println(((Cliente) clientes.get(0)).getNombre()[0]);

        System.out.println("CONSULTA CITAS\n" + gestorDB.consultarCitasDisp());
    }

    public void consultarCitas() {

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
