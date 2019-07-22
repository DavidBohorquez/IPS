/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistencia.DAO.ClienteDAO;
import persistencia.DAO.GestorDAO;
import persistencia.DAO.MedicoDAO;

/**
 *
 * @author Andre Sarmiento
 */
public class DAOFactory {

    private MedicoDAO medicosDB;
    private ClienteDAO clientesDB;
    private GestorDAO gestorDB;

    public DAOFactory() {

    }

    public MedicoDAO getMedicosDB() {
        if (medicosDB == null) {
            medicosDB = new MedicoDAO();
        }
        return medicosDB;
    }

    public ClienteDAO getClientesDB() {
        if (clientesDB == null) {
            clientesDB = new ClienteDAO();
        }
        return clientesDB;
    }

    public GestorDAO getGestorDB() {
        if (gestorDB == null) {
            gestorDB = new GestorDAO();
        }
        return gestorDB;
    }

}
