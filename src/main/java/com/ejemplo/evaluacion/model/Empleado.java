package com.ejemplo.evaluacion.model;

import jakarta.persistence.Entity;

@Entity
public class Empleado extends Usuario {
    private String cargo;
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