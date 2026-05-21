package com.duoc.PlataformaEducativa.service;

import com.duoc.PlataformaEducativa.dto.InscripcionRequestDTO;
import com.duoc.PlataformaEducativa.dto.InscripcionResponseDTO;
import com.duoc.PlataformaEducativa.model.Curso;
import com.duoc.PlataformaEducativa.model.Inscripcion;
import com.duoc.PlataformaEducativa.repository.CursoRepository;
import com.duoc.PlataformaEducativa.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public InscripcionResponseDTO registrarInscripcion(InscripcionRequestDTO request) {
        InscripcionResponseDTO response = new InscripcionResponseDTO();
        response.setEstudianteID(request.getEstudianteID());

        List<InscripcionResponseDTO.CursoResumenDTO> listaCursosResumen = new ArrayList<>();
        int total = 0;

        // Iterar sobre cada ID de curso solicitado
        for (Long cursoId : request.getCursoIDs()) {
            Curso curso = cursoRepository.findById(cursoId)
                    .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + cursoId));

            // Guardar la inscripción individual en la BD
            Inscripcion nuevaInscripcion = new Inscripcion();
            nuevaInscripcion.setCursoID(curso.getId());
            nuevaInscripcion.setEstudianteID(request.getEstudianteID());
            nuevaInscripcion.setFechaInscripcion(LocalDate.now());
            inscripcionRepository.save(nuevaInscripcion);

            // Sumar al total y añadir al DTO de respuesta
            total += curso.getCosto();
            listaCursosResumen.add(new InscripcionResponseDTO.CursoResumenDTO(curso.getNombre(), curso.getCosto()));
        }

        response.setCursosSeleccionados(listaCursosResumen);
        response.setTotalAPagar(total);

        return response;
    }

    public List<Inscripcion> listarTodasLasInscripciones() {
        return inscripcionRepository.findAll();
    }

    public void cancelarInscripcion(Long id) {
        Inscripcion ins = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
        inscripcionRepository.delete(ins);
    }

}