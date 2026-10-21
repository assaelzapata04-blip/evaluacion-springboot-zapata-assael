package com.ejemplo.evaluacion.model;

import jakarta.persistence.*;

@Entity
public class Solicitud {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String estado = "PENDIENTE";

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Solicitud() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente c) { this.cliente = c; }
}