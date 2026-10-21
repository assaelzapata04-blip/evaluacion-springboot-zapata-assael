package com.ejemplo.evaluacion.repository;

import com.ejemplo.evaluacion.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}