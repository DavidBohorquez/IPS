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
public class Medico extends Persona {

    private String codEsp;
    private Time hIncial;
    private Time hFinal;
    private String consultorio;
    private String sede;
    private Agenda agenda;

    public Medico() {

    }

    public String getCodEsp() {
        return codEsp;
    }

    public void setCodEsp(String codEsp) {
        this.codEsp = codEsp;
    }

    public Time gethIncial() {
        return hIncial;
    }

    public void sethIncial(Time hIncial) {
        this.hIncial = hIncial;
    }

    public Time gethFinal() {
        return hFinal;
    }

    public void sethFinal(Time hFinal) {
        this.hFinal = hFinal;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

}
