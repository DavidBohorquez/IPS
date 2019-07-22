/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentacion.vistas.LoginView;

/**
 *
 * @author Andre Sarmiento
 */
public class LoginController implements ActionListener {

    private LoginView login;

    public LoginController(LoginView login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
