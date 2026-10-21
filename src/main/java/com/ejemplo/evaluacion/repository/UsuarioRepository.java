package com.ejemplo.evaluacion.repository;

import com.ejemplo.evaluacion.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}