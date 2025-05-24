package com.recipeapp.backend.calificacion;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.usuario.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalificacionService {

    private final CalificacionRepository calificacionRepository;

    public List<Calificacion> obtenerTodas() {
        return calificacionRepository.findAll();
    }

    public List<Calificacion> obtenerPorReceta(Receta receta) {
        return calificacionRepository.findByReceta(receta);
    }

    public List<Calificacion> obtenerPorUsuario(Usuario usuario) {
        return calificacionRepository.findByUsuario(usuario);
    }

    public Optional<Calificacion> obtenerPorUsuarioYReceta(Usuario usuario, Receta receta) {
        return calificacionRepository.findByUsuarioAndReceta(usuario, receta);
    }

    public Calificacion guardar(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public void eliminar(Long id) {
        calificacionRepository.deleteById(id);
    }

    public Calificacion actualizarCalificacion(Long id, Calificacion calificacion) {
        Calificacion calificacionExistente = calificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        calificacionExistente.setCalificacion(calificacion.getCalificacion());
        calificacionExistente.setComentarios(calificacion.getComentarios());
        return calificacionRepository.save(calificacionExistente);
    }
}
