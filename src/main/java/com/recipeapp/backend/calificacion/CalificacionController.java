package com.recipeapp.backend.calificacion;


import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.receta.RecetaRepository;
import com.recipeapp.backend.usuario.Usuario;
import com.recipeapp.backend.usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RecetaRepository recetaRepository;

    @GetMapping
    public List<Calificacion> getAllRatings() {
        return calificacionService.getAllRatings();
    }

    @GetMapping("/receta/{id}")
    public ResponseEntity<List<Calificacion>> getRatingsByRecipe(@PathVariable Long recetaId) {
        return recetaRepository.findById(recetaId)
                .map(receta -> ResponseEntity.ok(calificacionService.getRatingsByRecipe(receta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Calificacion>> getRatingsByUser(@PathVariable Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .map(usuario -> ResponseEntity.ok(calificacionService.getRatingsByUser(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Calificacion> createRating(@RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.saveRating(calificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        calificacionService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.updateRating(id, calificacion));
    }
}
