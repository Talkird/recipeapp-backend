package com.recipeapp.backend.conversion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeapp.backend.unidad.Unidad;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    Optional<Conversion> findByUnidadOrigenAndUnidadDestino(Unidad unidadOrigen, Unidad unidadDestino);
}
