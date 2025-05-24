package com.recipeapp.backend.tiporeceta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TipoRecetaService {
    
    @Autowired
    private TipoRecetaRepository tipoRecetaRepository;
    public TipoReceta createTipoReceta(TipoReceta tipoReceta) {
        return tipoRecetaRepository.save(tipoReceta);
    }
    public TipoReceta getTipoRecetaById(Long idTipo) {
        return tipoRecetaRepository.findById(idTipo).orElse(null);
    }
    public TipoReceta getTipoRecetaByDescripcion(String descripcion) {
        return tipoRecetaRepository.findByDescripcion(descripcion);
    }
    public List<TipoReceta> getAllTiposReceta() {
        return tipoRecetaRepository.findAll();
    }
}
