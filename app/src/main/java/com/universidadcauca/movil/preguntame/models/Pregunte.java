package com.universidadcauca.movil.preguntame.models;

/**
 * Created by Sebastian on 09/04/2015.
 */
public class Pregunte {

    String pregunta, categoria, nivel_educativo;

    public Pregunte(String pregunta, String categoria, String nivel_educativo) {
        this.pregunta = pregunta;
        this.categoria = categoria;
        this.nivel_educativo = nivel_educativo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel_educativo() {
        return nivel_educativo;
    }

    public void setNivel_educativo(String nivel_educativo) {
        this.nivel_educativo = nivel_educativo;
    }
}
