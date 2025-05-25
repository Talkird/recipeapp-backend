package com.recipeapp.backend.unidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadService {
    @Autowired
    private UnidadRepository unidadRepository;

    public List<Unidad> getAllUnidades() {
        return unidadRepository.findAll();
    }

    public Optional<Unidad> getUnidadById(Long id) {
        return unidadRepository.findById(id);
    }

    public Unidad saveUnidad(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    public void deleteUnidad(Long id) {
        unidadRepository.deleteById(id);
    }

    public boolean existsByDescripcion(String descripcion) {
        return !unidadRepository.findByDescripcionContainingIgnoreCase(descripcion).isEmpty();
    }
}
