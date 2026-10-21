package com.ejemplo.evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Empleado extends Usuario {
    private String cargo;

    @NotNull(message = "El salario es obligatorio")
    @Positive(message = "El salario debe ser mayor que cero")
    private Double salario;

    public Empleado() {}
    public String getCargo() { return cargo; }
    public void setCargo(String c) { this.cargo = c; }
    public Double getSalario() { return salario; }
    public void setSalario(Double s) { this.salario = s; }

    @Override
    public String obtenerDescripcion() {
        return "Empleado " + getNombre() + " - " + cargo;
    }
}