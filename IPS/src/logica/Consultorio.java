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
public class Consultorio {

    private String numero;
    private Sede sede;
    private String tipo;
    private String desc;
    private ArrayList<Medico> medicos;
    private Time franja;

    public Consultorio(Sede sede) {
        this.sede = sede;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }

    public Time getFranja() {
        return franja;
    }

    public void setFranja(Time franja) {
        this.franja = franja;
    }

}
