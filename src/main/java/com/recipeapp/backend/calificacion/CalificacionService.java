package com.recipeapp.backend.calificacion;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.usuario.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

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
        return calificacionRepository.findById(id)
                .map(existingRating -> {
                    existingRating.setCalificacion(calificacion.getCalificacion());
                    existingRating.setComentarios(calificacion.getComentarios());
                    return calificacionRepository.save(existingRating);
                })
                .orElseThrow(() -> new RuntimeException("Rating not found with id: " + id));
    }
}
