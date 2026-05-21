package com.duoc.PlataformaEducativa.controller;

import com.duoc.PlataformaEducativa.dto.InscripcionRequestDTO;
import com.duoc.PlataformaEducativa.dto.InscripcionResponseDTO;
import com.duoc.PlataformaEducativa.model.Inscripcion;
import com.duoc.PlataformaEducativa.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // Endpoint: POST /inscripcion
    @PostMapping
    public ResponseEntity<InscripcionResponseDTO> inscribirEstudiante(@RequestBody InscripcionRequestDTO request) {
        InscripcionResponseDTO resultado = inscripcionService.registrarInscripcion(request);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inscripcion>> listarTodas() {
        return ResponseEntity.ok(inscripcionService.listarTodasLasInscripciones());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        inscripcionService.cancelarInscripcion(id);
        return ResponseEntity.noContent().build();
    }
}