package com.duoc.PlataformaEducativa.dto;

import java.util.List;

public class InscripcionResponseDTO {
    private Long estudianteID;
    private List<CursoResumenDTO> cursosSeleccionados;
    private int totalAPagar;

    // Getters y Setters
    public Long getEstudianteID() { return estudianteID; }
    public void setEstudianteID(Long estudianteID) { this.estudianteID = estudianteID; }

    public List<CursoResumenDTO> getCursosSeleccionados() { return cursosSeleccionados; }
    public void setCursosSeleccionados(List<CursoResumenDTO> cursosSeleccionados) { this.cursosSeleccionados = cursosSeleccionados; }

    public int getTotalAPagar() { return totalAPagar; }
    public void setTotalAPagar(int totalAPagar) { this.totalAPagar = totalAPagar; }

    // Clase interna para el detalle de cada curso en la respuesta
    public static class CursoResumenDTO {
        private String nombre;
        private int costo;

        public CursoResumenDTO(String nombre, int costo) {
            this.nombre = nombre;
            this.costo = costo;
        }

        // Getters y Setters
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public int getCosto() { return costo; }
        public void setCosto(int costo) { this.costo = costo; }
    }
}