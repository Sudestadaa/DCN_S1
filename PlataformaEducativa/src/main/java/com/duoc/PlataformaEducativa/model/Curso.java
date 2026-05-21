package com.duoc.PlataformaEducativa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long instructorID;
    private String duracion;
    private int costo;

    public Curso() {}

    // Getters y Setters
    public Long getId()                                             { return id; }
    public void setId(Long id)                                      { this.id = id; }

    public String getNombre()                                       { return nombre; }
    public void setNombre(String nombre)                            { this.nombre = nombre; }

    public Long getInstructorID()                                   { return instructorID; }
    public void setInstructorID(Long instructorID)                  { this.instructorID = instructorID; }

    public String getDuracion()                                     { return duracion; }
    public void setDuracion(String duracion)                        { this.duracion = duracion; }
    
    public int getCosto()                                           { return costo; }
    public void setCosto(int costo)                                 { this.costo = costo; }

}
