package com.recipeapp.backend.foto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoService {
    @Autowired
    private FotoRepository fotoRepository;

    public List<Foto> getAllFotos() {
        return fotoRepository.findAll();
    }

    public Optional<Foto> getFotoById(Long id) {
        return fotoRepository.findById(id);
    }

    public Foto saveFoto(Foto foto) {
        return fotoRepository.save(foto);
    }

    public void deleteFoto(Long id) {
        fotoRepository.deleteById(id);
    }
}
