package com.recipeapp.backend.asistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaCursoService {

    @Autowired
    private AsistenciaCursoRepository asistenciaCursoRepository;

    public List<AsistenciaCurso> getAllAsistencias() {
        return asistenciaCursoRepository.findAll();
    }

    public AsistenciaCurso getAsistenciaById(Long id) {
        return asistenciaCursoRepository.findById(id).orElse(null);
    }

    public List<AsistenciaCurso> getByAlumno(Long idAlumno) {
        return asistenciaCursoRepository.findByAlumnoIdAlumno(idAlumno);
    }

    public List<AsistenciaCurso> getByCronograma(Long idCronograma) {
        return asistenciaCursoRepository.findByCronogramaIdCronograma(idCronograma);
    }

    public AsistenciaCurso saveAsistencia(AsistenciaCurso asistencia) {
        return asistenciaCursoRepository.save(asistencia);
    }

    public void deleteAsistencia(Long id) {
        asistenciaCursoRepository.deleteById(id);
    }
}

