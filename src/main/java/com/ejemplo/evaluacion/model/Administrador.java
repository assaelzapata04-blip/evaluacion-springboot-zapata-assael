package com.ejemplo.evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Administrador extends Usuario {
    @NotNull(message = "El nivel de acceso es obligatorio")
    @Min(value = 1, message = "El nivel de acceso debe ser mínimo 1")
    @Max(value = 5, message = "El nivel de acceso debe ser máximo 5")
    private Integer nivelAcceso;

    public Administrador() {}
    public Integer getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(Integer n) { this.nivelAcceso = n; }

    @Override
    public String obtenerDescripcion() {
        return "Administrador " + getNombre() + " (nivel " + nivelAcceso + ")";
    }
}