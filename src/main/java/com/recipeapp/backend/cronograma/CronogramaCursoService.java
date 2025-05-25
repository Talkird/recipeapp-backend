package com.recipeapp.backend.cronograma;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CronogramaCursoService {
    
    @Autowired
    private CronogramaCursoRepository cronogramaCursoRepository;

    public List<CronogramaCurso> getAllCronogramas() {
        return cronogramaCursoRepository.findAll();
    }

    public CronogramaCurso getCronogramaById(Long id) {
        return cronogramaCursoRepository.findById(id).orElse(null);
    }
    
    public List<CronogramaCurso> getCronogramasByFechaInicio(Date fechaInicio) {
        return cronogramaCursoRepository.findByFechaInicio(fechaInicio);
    }

    public List<CronogramaCurso> getCronogramasByFechaFin(Date fechaFin) {
        return cronogramaCursoRepository.findByFechaFin(fechaFin);
    }

    public List<CronogramaCurso> getCronogramasByFechaInicioBetween(Date startDate, Date endDate) {
        return cronogramaCursoRepository.findByFechaInicioBetween(startDate, endDate);
    }

    public List<CronogramaCurso> getCronogramasByFechaFinBetween(Date startDate, Date endDate) {
        return cronogramaCursoRepository.findByFechaFinBetween(startDate, endDate);
    }

    public List<CronogramaCurso> getCronogramasBySedeId(Long idSede) {
        return cronogramaCursoRepository.findBySede_IdSede(idSede);
    }

    public List<CronogramaCurso> getCronogramasByCursoId(Long idCurso) {
        return cronogramaCursoRepository.findByCurso_IdCurso(idCurso);
    }

    public List<CronogramaCurso> getCronogramasByCursoIdAndSedeId(Long idCurso, Long idSede) {
        return cronogramaCursoRepository.findByCurso_IdCursoAndSede_IdSede(idCurso, idSede);
    }

    public List<CronogramaCurso> getCronogramasByFechaInicioBetweenAndSedeId(Date startDate, Date endDate, Long idSede) {
        return cronogramaCursoRepository.findByFechaInicioBetweenAndSede_IdSede(startDate, endDate, idSede);
    }

    public List<CronogramaCurso> getCronogramasByFechaInicioBetweenAndCursoId(Date startDate, Date endDate, Long idCurso) {
        return cronogramaCursoRepository.findByFechaInicioBetweenAndCurso_IdCurso(startDate, endDate, idCurso);
    }

    public CronogramaCurso saveCronograma(CronogramaCurso cronograma) {
        return cronogramaCursoRepository.save(cronograma);
    }

    public CronogramaCurso updateCronograma(Long id, CronogramaCurso cronograma) {
        CronogramaCurso existingCronograma = cronogramaCursoRepository.findById(id).orElse(null);
        if (existingCronograma != null) {
            existingCronograma.setFechaInicio(cronograma.getFechaInicio());
            existingCronograma.setFechaFin(cronograma.getFechaFin());
            existingCronograma.setVacantesDisponibles(cronograma.getVacantesDisponibles());
            return cronogramaCursoRepository.save(existingCronograma);
        }
        return null;
    }

    public void deleteCronograma(Long id) {
        cronogramaCursoRepository.deleteById(id);
    }
}
