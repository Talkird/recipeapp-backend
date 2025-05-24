package com.recipeapp.backend.calificacion;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByReceta(Receta receta);
    List<Calificacion> findByUsuario(Usuario usuario);
    Optional<Calificacion> findByUsuarioAndReceta(Usuario usuario, Receta receta);
    void deleteById(Long id);
}

