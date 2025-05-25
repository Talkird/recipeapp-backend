package com.recipeapp.backend.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> getUsuarioByMail(String mail) {
        return usuarioRepository.findByMail(mail);
    }

    public Optional<Usuario> getUsuarioByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existsByMail(String mail) {
        return usuarioRepository.existsByMail(mail);
    }

    public boolean existsByNickname(String nickname) {
        return usuarioRepository.existsByNickname(nickname);
    }

    public List<String> sugerirNicknames(String nicknameBase) {
        List<Usuario> similares = usuarioRepository.findByNicknameStartingWith(nicknameBase);
        List<String> existentes = similares.stream().map(Usuario::getNickname).collect(Collectors.toList());
        // Genera 5 sugerencias que no estén en uso
        return java.util.stream.IntStream.range(1, 10)
                .mapToObj(i -> nicknameBase + i)
                .filter(nick -> !existentes.contains(nick))
                .limit(5)
                .collect(Collectors.toList());
    }
}
