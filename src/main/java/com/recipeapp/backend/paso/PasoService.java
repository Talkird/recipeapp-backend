package com.recipeapp.backend.paso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasoService {
    @Autowired
    private PasoRepository pasoRepository;

    public List<Paso> getAllPasos() {
        return pasoRepository.findAll();
    }

    public Optional<Paso> getPasoById(Long id) {
        return pasoRepository.findById(id);
    }

    public Paso savePaso(Paso paso) {
        return pasoRepository.save(paso);
    }

    public void deletePaso(Long id) {
        pasoRepository.deleteById(id);
    }

    public List<Paso> getPasosByRecetaId(Long idReceta) {
        return pasoRepository.findByRecetaIdRecetaOrderByNroPasoAsc(idReceta);
    }
}
