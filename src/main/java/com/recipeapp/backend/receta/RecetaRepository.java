package com.recipeapp.backend.receta;

import org.springframework.stereotype.Repository;

import com.recipeapp.backend.tiporeceta.TipoReceta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
    Receta findByNombreReceta(String nombreReceta);
    List<Receta> findByTipo(TipoReceta tipoReceta);
}
