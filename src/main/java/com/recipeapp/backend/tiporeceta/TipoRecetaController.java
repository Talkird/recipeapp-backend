package com.recipeapp.backend.tiporeceta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tiporeceta")
public class TipoRecetaController {
    
    @Autowired
    private TipoRecetaService tipoRecetaService;

    @PostMapping("/create")
    public TipoReceta createTipoReceta(TipoReceta tipoReceta) {
        return tipoRecetaService.createTipoReceta(tipoReceta);
    }
    @PostMapping("/getById")
    public TipoReceta getTipoRecetaById(Long idTipo) {
        return tipoRecetaService.getTipoRecetaById(idTipo);
    }

    @PostMapping("/getByDescripcion")
    public TipoReceta getTipoRecetaByDescripcion(String descripcion) {
        return tipoRecetaService.getTipoRecetaByDescripcion(descripcion);
    }

    @PostMapping("/getAll")
    public List<TipoReceta> getAllTiposReceta() {
        return tipoRecetaService.getAllTiposReceta();
    }
    

}
