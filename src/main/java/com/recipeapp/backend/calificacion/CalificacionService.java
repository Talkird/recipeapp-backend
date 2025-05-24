package com.recipeapp.backend.calificacion;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    public List<Calificacion> getAllRatings() {
        return calificacionRepository.findAll();
    }

    public List<Calificacion> getRatingsByRecipe(Receta recipe) {
        return calificacionRepository.findByReceta(recipe);
    }

    public List<Calificacion> getRatingsByUser(Usuario user) {
        return calificacionRepository.findByUsuario(user);
    }

    public Optional<Calificacion> getRatingByUserAndRecipe(Usuario user, Receta recipe) {
        return calificacionRepository.findByUsuarioAndReceta(user, recipe);
    }

    public Calificacion saveRating(Calificacion rating) {
        return calificacionRepository.save(rating);
    }

    public void deleteRating(Long id) {
        calificacionRepository.deleteById(id);
    }

    public Calificacion updateRating(Long id, Calificacion calificacion) {
        Calificacion calificacionExistente = calificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        calificacionExistente.setCalificacion(calificacion.getCalificacion());
        calificacionExistente.setComentarios(calificacion.getComentarios());
        return calificacionRepository.save(calificacionExistente);
    }
}
