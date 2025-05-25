package com.recipeapp.backend.utilizado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/utilizados")
public class UtilizadoController {
    @Autowired
    private UtilizadoService utilizadoService;

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll() {
        try {
            List<Utilizado> utilizados = utilizadoService.findAll();
            return ResponseEntity.ok(utilizados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al obtener la lista de utilizados.");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Utilizado utilizado = utilizadoService.findById(id);
            if (utilizado != null) {
                return ResponseEntity.ok(utilizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el utilizado con id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al obtener el utilizado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Utilizado utilizado) {
        try {
            Utilizado nuevo = utilizadoService.save(utilizado);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al crear el utilizado.");
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            utilizadoService.deleteById(id);
            return ResponseEntity.ok("Utilizado eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar el utilizado.");
        }
    }
}