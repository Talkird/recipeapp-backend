package com.recipeapp.backend.utilizado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service

public class UtilizadoService {
    @Autowired
    private UtilizadoRepository utilizadoRepository;

    public List<Utilizado> findAll() {
        return utilizadoRepository.findAll();
    }

    public Utilizado findById(Long id) {
        Optional<Utilizado> utilizado = utilizadoRepository.findById(id);
        return utilizado.orElse(null);
    }

    public Utilizado save(Utilizado utilizado) {
        return utilizadoRepository.save(utilizado);
    }

    public void deleteById(Long id) {
        utilizadoRepository.deleteById(id);
    }
}
