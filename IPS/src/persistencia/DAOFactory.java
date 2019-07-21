/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import persistencia.DAO.ConsultorioDAO;
import persistencia.DAO.MedicoDAO;
import persistencia.DAO.SedeDAO;

/**
 *
 * @author Andre Sarmiento
 */
public class DAOFactory {

    private MedicoDAO medicosDB;
    private SedeDAO sedesDB;
    private ConsultorioDAO consultoriosDB;

    public DAOFactory() {

    }

    public MedicoDAO getMedicosDB() {
        if (medicosDB == null) {
            medicosDB = new MedicoDAO();
        }
        return medicosDB;
    }
    
    public SedeDAO getSedeDAO() {
        if(sedesDB == null) {
            sedesDB = new SedeDAO();
        }
        return sedesDB;
    }

    public ConsultorioDAO getConsultoriosDB() {
        if(consultoriosDB == null) {
            consultoriosDB = new ConsultorioDAO();
        }
        return consultoriosDB;
    }
}
