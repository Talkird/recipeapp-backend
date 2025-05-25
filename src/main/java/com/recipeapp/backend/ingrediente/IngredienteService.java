package com.recipeapp.backend.ingrediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> obtenerTodos() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> obtenerPorId(Long id) {
        return ingredienteRepository.findById(id);
    }

    public Ingrediente guardar(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public void eliminar(Long id) {
        ingredienteRepository.deleteById(id);
    }
}
