package com.duoc.PlataformaEducativa.dto;

import java.util.List;

public class InscripcionRequestDTO {
    private Long estudianteID;
    private List<Long> cursoIDs;

    // Getters y Setters
    public Long getEstudianteID() { return estudianteID; }
    public void setEstudianteID(Long estudianteID) { this.estudianteID = estudianteID; }

    public List<Long> getCursoIDs() { return cursoIDs; }
    public void setCursoIDs(List<Long> cursoIDs) { this.cursoIDs = cursoIDs; }
}