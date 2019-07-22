/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Time;
import java.util.ArrayList;

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
    private String especializacion;
    private String agendaEstado;

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

    public String getAgenda() {
        return agendaEstado;
    }

    public void setAgenda(String agenda) {
        this.agendaEstado = agenda;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

}
