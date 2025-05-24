package com.recipeapp.backend.utilizado;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UtilizadoRepository extends JpaRepository<Utilizado, Long> {

    List<Utilizado> findByRecetaIdReceta(Long idReceta);


    List<Utilizado> findByIngredienteIdIngrediente(Long idIngrediente);


    List<Utilizado> findByUnidadIdUnidad(Long idUnidad);


    List<Utilizado> findByObservacionesContainingIgnoreCase(String texto);


}
