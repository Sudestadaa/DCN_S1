package com.duoc.PlataformaEducativa.repository;

import com.duoc.PlataformaEducativa.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}