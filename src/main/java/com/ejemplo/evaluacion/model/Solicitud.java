package com.ejemplo.evaluacion.model;

import jakarta.persistence.*;

@Entity
public class Solicitud {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String estado = "PENDIENTE";

    public Solicitud() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
}