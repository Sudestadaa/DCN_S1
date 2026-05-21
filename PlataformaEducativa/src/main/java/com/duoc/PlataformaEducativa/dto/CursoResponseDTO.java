package com.duoc.PlataformaEducativa.dto;

public class CursoResponseDTO {
    private Long id;
    private String nombre;
    private String instructorNombre;
    private String duracion;
    private int costo;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getInstructorNombre() { return instructorNombre; }
    public void setInstructorNombre(String instructorNombre) { this.instructorNombre = instructorNombre; }

    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }

    public int getCosto() { return costo; }
    public void setCosto(int costo) { this.costo = costo; }
}