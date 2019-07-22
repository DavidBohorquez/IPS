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
import persistencia.DAO.MedicoDAO;
import persistencia.DAOFactory;
import presentacion.vistas.LoginView;

/**
 *
 * @author Andre Sarmiento
 */
public class Modelo {

    private ArrayList<Medico> medicos;
    private ArrayList<Cliente> clientes;

    private LoginView ventanaLogin;

    private DAOFactory dbFactory;

    public Modelo() throws SQLException {
        iniciar();
    }

    public void iniciar() throws SQLException {
        dbFactory = getDbFactory();

        MedicoDAO medicosDB = dbFactory.getMedicosDB();

        ClienteDAO clientesDB = dbFactory.getClientesDB();

        clientes = (ArrayList<Cliente>) (List) clientesDB.consultar();

        medicos = (ArrayList<Medico>) (List) medicosDB.consultar();

        ventanaLogin = getVentanaLogin();

        ventanaLogin.setVisible(true);

        /*GestorDAO gestorDB = dbFactory.getGestorDB();

        List medicos = medicosDB.consultar();

        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(((Medico) medicos.get(i)).getNombre()[0]);
            System.out.println(((Medico) medicos.get(i)).getSede());
            System.out.println(((Medico) medicos.get(i)).getEspecializacion());
        }

        List clientes = clientesDB.consultar();

        System.out.println(((Cliente) clientes.get(0)).getNombre()[0]);

        System.out.println("CONSULTA CITAS\n" + gestorDB.consultarCitasDisp());

        Cliente cliente = new Cliente();
        cliente.setId(1000614894);

        gestorDB.asignarCita(1, "A", cliente);*/
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
