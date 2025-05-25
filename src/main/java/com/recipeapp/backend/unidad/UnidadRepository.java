package com.recipeapp.backend.unidad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Long> {
    List<Unidad> findByDescripcionContainingIgnoreCase(String descripcion);
}
