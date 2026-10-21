package com.ejemplo.evaluacion.controller;

import com.ejemplo.evaluacion.model.Cliente;
import com.ejemplo.evaluacion.model.Solicitud;
import com.ejemplo.evaluacion.model.Usuario;
import com.ejemplo.evaluacion.repository.SolicitudRepository;
import com.ejemplo.evaluacion.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final SolicitudRepository repo;
    private final UsuarioRepository usuarioRepo;

    public SolicitudController(SolicitudRepository repo, UsuarioRepository usuarioRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Solicitud s) {
        if (s.getCliente() == null || s.getCliente().getId() == null) {
            return ResponseEntity.badRequest().body("Debe indicar el cliente");
        }
        Usuario u = usuarioRepo.findById(s.getCliente().getId()).orElse(null);
        if (!(u instanceof Cliente)) {
            return ResponseEntity.badRequest().body("El cliente no existe");
        }
        s.setCliente((Cliente) u);
        return ResponseEntity.ok(repo.save(s));
    }

    @GetMapping
    public Page<Solicitud> listar(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}