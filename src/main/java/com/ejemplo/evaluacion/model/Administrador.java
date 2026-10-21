package com.ejemplo.evaluacion.model;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario {
    private Integer nivelAcceso;

    public Administrador() {}
    public Integer getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(Integer n) { this.nivelAcceso = n; }

    @Override
    public String obtenerDescripcion() {
        return "Administrador " + getNombre() + " (nivel " + nivelAcceso + ")";
    }
}