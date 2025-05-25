package com.recipeapp.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<Usuario> getUsuarioByMail(@PathVariable String mail) {
        return usuarioService.getUsuarioByMail(mail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<Usuario> getUsuarioByNickname(@PathVariable String nickname) {
        return usuarioService.getUsuarioByNickname(nickname)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sugerencias/{nicknameBase}")
    public List<String> sugerirNicknames(@PathVariable String nicknameBase) {
        return usuarioService.sugerirNicknames(nicknameBase);
    }
}
