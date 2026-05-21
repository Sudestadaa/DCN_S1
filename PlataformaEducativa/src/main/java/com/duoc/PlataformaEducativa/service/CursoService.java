package com.duoc.PlataformaEducativa.service;

import com.duoc.PlataformaEducativa.dto.CursoResponseDTO;
import com.duoc.PlataformaEducativa.model.Curso;
import com.duoc.PlataformaEducativa.model.Usuario;
import com.duoc.PlataformaEducativa.repository.CursoRepository;
import com.duoc.PlataformaEducativa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; 

    
    public List<CursoResponseDTO> listarCursosConInstructor() {
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoResponseDTO> dtos = new ArrayList<>();

        for (Curso curso : cursos) {
            CursoResponseDTO dto = new CursoResponseDTO();
            dto.setId(curso.getId());
            dto.setNombre(curso.getNombre());
            dto.setDuracion(curso.getDuracion());
            dto.setCosto(curso.getCosto());

            // Buscamos el usuario y extraemos su nombre si existe
            String nombreInstructor = usuarioRepository.findById(curso.getInstructorID())
                    .map(Usuario::getNombre)
                    .orElse("Instructor no encontrado (ID: " + curso.getInstructorID() + ")");
            
            dto.setInstructorNombre(nombreInstructor);
            dtos.add(dto);
        }
        return dtos;
    }

    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso guardarCurso(Curso curso) {
        // Validar que el instructor exista antes de guardar el curso
        usuarioRepository.findById(curso.getInstructorID())
                .orElseThrow(() -> new RuntimeException("No se puede crear el curso: El Instructor no existe."));
        return cursoRepository.save(curso);
    }

    public Curso actualizarCurso(Long id, Curso detalles) {
        Curso curso = obtenerPorId(id);
        curso.setNombre(detalles.getNombre());
        curso.setDuracion(detalles.getDuracion());
        curso.setCosto(detalles.getCosto());
        curso.setInstructorID(detalles.getInstructorID());
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.delete(obtenerPorId(id));
    }
}