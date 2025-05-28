package com.recipeapp.backend.asistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaCursoController {

    @Autowired
    private AsistenciaCursoService asistenciaCursoService;

    @GetMapping
    public List<AsistenciaCurso> getAllAsistencias() {
        return asistenciaCursoService.getAllAsistencias();
    }

    @GetMapping("/{id}")
    public AsistenciaCurso getAsistenciaById(@PathVariable Long id) {
        return asistenciaCursoService.getAsistenciaById(id);
    }

    @GetMapping("/por-alumno/{idAlumno}")
    public List<AsistenciaCurso> getByAlumno(@PathVariable Long idAlumno) {
        return asistenciaCursoService.getByAlumno(idAlumno);
    }

    @GetMapping("/por-cronograma/{idCronograma}")
    public List<AsistenciaCurso> getByCronograma(@PathVariable Long idCronograma) {
        return asistenciaCursoService.getByCronograma(idCronograma);
    }

    @PostMapping
    public AsistenciaCurso saveAsistencia(@RequestBody AsistenciaCurso asistencia) {
        return asistenciaCursoService.saveAsistencia(asistencia);
    }

    @DeleteMapping("/{id}")
    public void deleteAsistencia(@PathVariable Long id) {
        asistenciaCursoService.deleteAsistencia(id);
    }
}
