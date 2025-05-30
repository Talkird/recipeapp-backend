package com.recipeapp.backend.paso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasoRepository extends JpaRepository<Paso, Long> {
    List<Paso> findByRecetaIdRecetaOrderByNroPasoAsc(Long idReceta);
}
