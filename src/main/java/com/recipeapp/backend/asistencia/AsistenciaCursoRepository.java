package com.recipeapp.backend.asistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaCursoRepository extends JpaRepository<AsistenciaCurso, Long> {
    List<AsistenciaCurso> findByAlumnoIdAlumno(Long idAlumno);
    List<AsistenciaCurso> findByCronogramaIdCronograma(Long idCronograma);
}
