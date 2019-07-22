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
public class Cliente extends Persona {

    private String estado;
    private String parentesco;
    private String estadoMulta;
    private Categoria categoria;

    public Cliente(Categoria categoria) {
        this.categoria = categoria;
    }
    public Cliente() {
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEstadoMulta() {
        return estadoMulta;
    }

    public void setEstadoMulta(String estadoMulta) {
        this.estadoMulta = estadoMulta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
