package com.ejemplo.evaluacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Usuario {
    private Integer puntosFidelidad;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Solicitud> solicitudes = new ArrayList<>();

    public Cliente() {}
    public Integer getPuntosFidelidad() { return puntosFidelidad; }
    public void setPuntosFidelidad(Integer p) { this.puntosFidelidad = p; }
    public List<Solicitud> getSolicitudes() { return solicitudes; }

    @Override
    public String obtenerDescripcion() {
        return "Cliente " + getNombre() + " con " + puntosFidelidad + " puntos";
    }
}