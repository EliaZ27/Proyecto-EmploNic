package com.emplonic.brothersapp.emplonic;

/**
 * Created by usuario on 22/11/2016.
 */

public class Empleo {
    private int imagen;
    private String nombre;
    private String Requisitos;

    public Empleo(int imagen, String nombre, String Requisitos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.Requisitos = Requisitos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRequisitos() {
        return Requisitos;
    }

    public int getImagen() {
        return imagen;
    }
}
