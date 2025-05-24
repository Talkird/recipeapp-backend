package com.recipeapp.backend.calificacion;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.receta.RecetaRepository;
import com.recipeapp.backend.usuario.Usuario;
import com.recipeapp.backend.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
@RequiredArgsConstructor
public class CalificacionController {

    private final CalificacionService calificacionService;
    private final UsuarioRepository usuarioRepository;
    private final RecetaRepository recetaRepository;

    @GetMapping
    public List<Calificacion> listarTodas() {
        return calificacionService.obtenerTodas();
    }

    @GetMapping("/receta/{idReceta}")
    public ResponseEntity<List<Calificacion>> listarPorReceta(@PathVariable Long idReceta) {
        return recetaRepository.findById(idReceta)
                .map(receta -> ResponseEntity.ok(calificacionService.obtenerPorReceta(receta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Calificacion>> listarPorUsuario(@PathVariable Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(usuario -> ResponseEntity.ok(calificacionService.obtenerPorUsuario(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.guardar(calificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable Long id) {
        calificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return ResponseEntity.ok(calificacionService.actualizarCalificacion(id, calificacion));
    }
}
