package com.recipeapp.backend.curso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long idCurso) {
        Curso curso = cursoService.getCursoById(idCurso);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombreCurso}")
    public ResponseEntity<Curso> getCursoByDescription(@RequestParam String descripcion) {
        Curso curso = cursoService.getCursoByDescription(descripcion);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    @GetMapping("/modalidad/{modalidad}")
    public List<Curso> getCursosByModalidad(@PathVariable String modalidad) {
        return cursoService.getCursosByModalidad(modalidad);
    }

    @GetMapping("/sede/{sede}")
    public List<Curso> getCursosBySede(@PathVariable Long idSede) {
        return cursoService.getCursosBySede(idSede);
    }

    @GetMapping("/vacantes")
    public List<Curso> getCursosWithVacantes() {
        return cursoService.getCursosWithVacantes();
    }

    @GetMapping("/promocion")
    public List<Curso> getCursosWithPromocion() {
        return cursoService.getCursosWithPromocion();
    }

    @GetMapping("/precio/asc")
    public List<Curso> getCursosOrderByPrecioAsc() {
        return cursoService.getCursosOrderByPrecioAsc();
    }

    @GetMapping("/precio/desc")
    public List<Curso> getCursosOrderByPrecioDesc() {
        return cursoService.getCursosOrderByPrecioDesc();
    }

    @GetMapping("/duracion/asc")
    public List<Curso> getCursosOrderByDuracionAsc() {
        return cursoService.getCursosOrderByDuracionAsc();
    }
    
    @GetMapping("/duracion/desc")
    public List<Curso> getCursosOrderByDuracionDesc() {
        return cursoService.getCursosOrderByDuracionDesc();
    }
    
    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long idCurso, @RequestBody Curso curso) {
        Curso actualizado = cursoService.updateCurso(idCurso, curso);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long idCurso) {
        cursoService.deleteCurso(idCurso);
        return ResponseEntity.noContent().build();
    }
}

