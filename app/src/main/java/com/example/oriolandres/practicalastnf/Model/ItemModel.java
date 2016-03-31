package com.example.oriolandres.practicalastnf.Model;

import java.io.Serializable;

/**
 * Created by oriolandres on 15/3/16.
 */
 public class ItemModel implements Serializable{

    private String nombrePersona,texto;
    private int dinero;


    public ItemModel(String nombrePersona, int dinero, String texto) {
        this.nombrePersona = nombrePersona;
        this.dinero=dinero;
        this.texto = texto;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getTexto() {
        return texto;
    }

    public String getDinero() {
        return dinero +" €";
    }
}
