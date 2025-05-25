package com.recipeapp.backend.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return ResponseEntity.noContent().build();
    }

}