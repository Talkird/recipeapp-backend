package com.recipeapp.backend.receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeapp.backend.tiporeceta.TipoReceta;
import com.recipeapp.backend.tiporeceta.TipoRecetaService;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private TipoRecetaService tipoRecetaService;

    public Receta createReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    public Receta getRecetaById(Long idReceta) {
        return recetaRepository.findById(idReceta).orElse(null);
    }

    public Receta getRecetaByNombre(String nombreReceta) {
        return recetaRepository.findByNombreReceta(nombreReceta);
    }

    public List<Receta> getAllRecetas() {
        return recetaRepository.findAll();
    }

    public Receta updateReceta(Long idReceta, Receta receta) {
        Optional<Receta> recetaExistente = recetaRepository.findById(idReceta);
        if (recetaExistente.isPresent()) {
            Receta r = recetaExistente.get();
            r.setNombreReceta(receta.getNombreReceta());
            r.setDescripcionReceta(receta.getDescripcionReceta());
            r.setFotoPrincipal(receta.getFotoPrincipal());
            r.setPorciones(receta.getPorciones());
            r.setCantidadPersonas(receta.getCantidadPersonas());
            r.setTipo(receta.getTipo());
            r.setPasos(receta.getPasos());
            r.setUtilizados(receta.getUtilizados());
            r.setCalificaciones(receta.getCalificaciones());
            r.setFotos(receta.getFotos());
            r.setMultimedia(receta.getMultimedia());
            r.setUsuario(receta.getUsuario());
            return recetaRepository.save(r);
        } else {
            return null;
        }
    }

    public void deleteReceta(Long idReceta) {
        recetaRepository.deleteById(idReceta);
    }

    public List<Receta> getRecetasByTipo(TipoReceta tipoReceta) {
        return recetaRepository.findByTipo(tipoReceta);
    }

    public List<Receta> getRecetasByTipoId(Long idTipo) {
        TipoReceta tipo = tipoRecetaService.getTipoRecetaById(idTipo);
        if (tipo == null) return List.of();
        return recetaRepository.findByTipo(tipo);
    }
}
