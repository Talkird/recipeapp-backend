package com.recipeapp.backend.paso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasos")
public class PasoController {
    @Autowired
    private PasoService pasoService;

    @GetMapping
    public List<Paso> getAllPasos() {
        return pasoService.getAllPasos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paso> getPasoById(@PathVariable Long id) {
        return pasoService.getPasoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paso createPaso(@RequestBody Paso paso) {
        return pasoService.savePaso(paso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaso(@PathVariable Long id) {
        pasoService.deletePaso(id);
        return ResponseEntity.noContent().build();
    }
}
