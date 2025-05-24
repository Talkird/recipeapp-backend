package com.recipeapp.backend.sede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedeService {
    
    @Autowired
    private SedeRepository sedeRepository;
    
    public List<Sede> getAllSedes() {
        return sedeRepository.findAll();
    }

    public void addSede(Sede sede) {
        if (sedeRepository.findByNombreSede(sede.getNombreSede()).isPresent()) return;
        sedeRepository.save(sede);
    }

    public void removeSede(Long idSede) {
        sedeRepository.deleteById(idSede);
    }

    public Sede getSede(Long idSede) {
        return sedeRepository.findById(idSede).orElse(null);
    }

    public Sede getSedeByNombre(String nombreSede) {
        return sedeRepository.findByNombreSede(nombreSede).orElse(null);
    }

}
