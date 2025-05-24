package com.recipeapp.backend.calificacion;


import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.receta.RecetaRepository;
import com.recipeapp.backend.usuario.Usuario;
import com.recipeapp.backend.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class CalificacionController {

    private final CalificacionService ratingService;
    private final UsuarioRepository userRepository;
    private final RecetaRepository recipeRepository;

    @GetMapping
    public List<Calificacion> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Calificacion>> getRatingsByRecipe(@PathVariable Long recipeId) {
        return recipeRepository.findById(recipeId)
                .map(recipe -> ResponseEntity.ok(ratingService.getRatingsByRecipe(recipe)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Calificacion>> getRatingsByUser(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> ResponseEntity.ok(ratingService.getRatingsByUser(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Calificacion> createRating(@RequestBody Calificacion rating) {
        return ResponseEntity.ok(ratingService.saveRating(rating));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(ratingService.updateRating(id, calificacion));
    }
}
