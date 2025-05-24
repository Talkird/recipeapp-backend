package com.recipeapp.backend.tiporeceta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRecetaRepository extends JpaRepository<TipoReceta, Long> {
    TipoReceta findByDescripcion(String descripcion);
    void deleteById(Long idTipo);
    
}
