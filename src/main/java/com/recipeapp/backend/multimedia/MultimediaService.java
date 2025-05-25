package com.recipeapp.backend.multimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultimediaService {
    @Autowired
    private MultimediaRepository multimediaRepository;

    public List<Multimedia> getAllMultimedia() {
        return multimediaRepository.findAll();
    }

    public Optional<Multimedia> getMultimediaById(Long id) {
        return multimediaRepository.findById(id);
    }

    public Multimedia saveMultimedia(Multimedia multimedia) {
        return multimediaRepository.save(multimedia);
    }

    public void deleteMultimedia(Long id) {
        multimediaRepository.deleteById(id);
    }

    public List<Multimedia> getMultimediaByPasoId(Long idPaso) {
        return multimediaRepository.findByPasoIdPaso(idPaso);
    }

    public List<Multimedia> getMultimediaByPasoIdAndTipo(Long idPaso, String tipoContenido) {
        return multimediaRepository.findByPasoIdPasoAndTipoContenido(idPaso, tipoContenido);
    }
}
