package com.recipeapp.backend.utilizado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadoRepository extends JpaRepository<Utilizado, Long> {
    // Métodos personalizados si son necesarios
}
