/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Andre Sarmiento
 */
public class Agenda {

    private int id;
    private Date fecha;
    private char estado;
    private ArrayList<Cita> citas;

    public Agenda(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public ArrayList<Cita> getCita() {
        return citas;
    }

    public void setCita(ArrayList<Cita> cita) {
        this.citas = citas;
    }

}
