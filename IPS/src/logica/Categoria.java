/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Andre Sarmiento
 */
public class Categoria {

    private char tipo;
    private int copago;
    private int multa;

    public Categoria(char tipo, int copago, int multa) {
        this.tipo = tipo;
        this.copago = copago;
        this.multa = multa;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getCopago() {
        return copago;
    }

    public void setCopago(int copago) {
        this.copago = copago;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

}
