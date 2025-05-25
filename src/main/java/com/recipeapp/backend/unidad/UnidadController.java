package com.recipeapp.backend.unidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/unidades")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;

    @GetMapping
    public List<Unidad> getAllUnidades() {
        return unidadService.getAllUnidades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidad> getUnidadById(@PathVariable Long id) {
        return unidadService.getUnidadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unidad createUnidad(@RequestBody Unidad unidad) {
        return unidadService.saveUnidad(unidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidad(@PathVariable Long id) {
        unidadService.deleteUnidad(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Unidad> searchUnidades(@RequestParam String descripcion) {
        return unidadService.getAllUnidades().stream()
                .filter(unidad -> unidad.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                .collect(Collectors.toList());
    }
}
