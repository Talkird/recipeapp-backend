package com.recipeapp.backend.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByMail(String mail);

    Optional<Usuario> findByNickname(String nickname);

    boolean existsByMail(String mail);

    boolean existsByNickname(String nickname);

    List<Usuario> findByNicknameStartingWith(String prefix);
}
