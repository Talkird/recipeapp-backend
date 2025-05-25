package com.recipeapp.backend.cronograma;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface CronogramaCursoRepository extends JpaRepository<CronogramaCurso, Long> {
    List<CronogramaCurso> findByFechaInicio(Date fechaInicio);
    List<CronogramaCurso> findByFechaFin(Date fechaFin);
    List<CronogramaCurso> findByCurso_IdCurso(Long idCurso);
    List<CronogramaCurso> findBySede_IdSede(Long idSede);
    List<CronogramaCurso> findByCurso_IdCursoAndSede_IdSede(Long idCurso, Long idSede);
    List<CronogramaCurso> findByFechaInicioBetween(Date startDate, Date endDate);
    List<CronogramaCurso> findByFechaFinBetween(Date startDate, Date endDate);
    List<CronogramaCurso> findByFechaInicioBetweenAndSede_IdSede(Date startDate, Date endDate, Long idSede);
    List<CronogramaCurso> findByFechaInicioBetweenAndCurso_IdCurso(Date startDate, Date endDate, Long idCurso);
}

