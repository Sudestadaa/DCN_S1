package com.duoc.PlataformaEducativa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cursoID;
    private Long estudianteID;
    private java.time.LocalDate fechaInscripcion;

    public Inscripcion() {}

    // Getters y Setters
    public Long getId()                                                     { return id; }
    public void setId(Long id)                                              { this.id = id; }

    public Long getCursoID()                                                { return cursoID; }
    public void setCursoID(Long cursoID)                                    { this.cursoID = cursoID; }

    public Long getEstudianteID()                                           { return estudianteID; }
    public void setEstudianteID(Long estudianteID)                          { this.estudianteID = estudianteID; }
    
    public java.time.LocalDate getFechaInscripcion()                        { return fechaInscripcion; }
    public void setFechaInscripcion(java.time.LocalDate fechaInscripcion)   { this.fechaInscripcion = fechaInscripcion; }

}
