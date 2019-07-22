/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Time;

/**
 *
 * @author Andre Sarmiento
 */
public class Cita {

    private int id;
    private String estado;
    private String prescripcion;
    private String descripcion;
    private Cliente cliente;
    private Time hInicial;
    private Time hFinal;
    private String tipoCita;
    private Multa multa;

    public Cita() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrescripcion() {
        return prescripcion;
    }

    public void setPrescripcion(String prescripcion) {
        this.prescripcion = prescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Time gethInicial() {
        return hInicial;
    }

    public void sethInicial(Time hInicial) {
        this.hInicial = hInicial;
    }

    public Time gethFinal() {
        return hFinal;
    }

    public void sethFinal(Time hFinal) {
        this.hFinal = hFinal;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

}
