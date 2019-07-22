/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistencia.DAO.MedicoDAO;

/**
 *
 * @author Andre Sarmiento
 */
public class DAOFactory {

    private MedicoDAO medicosDB;

    public DAOFactory() {

    }

    public MedicoDAO getMedicosDB() {
        if (medicosDB == null) {
            medicosDB = new MedicoDAO();
        }
        return medicosDB;
    }
}
