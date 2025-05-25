package com.recipeapp.backend.multimedia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
    List<Multimedia> findByPasoIdPaso(Long idPaso);

    List<Multimedia> findByPasoIdPasoAndTipoContenido(Long idPaso, String tipoContenido);
}
