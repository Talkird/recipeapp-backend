package com.recipeapp.backend.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.recipeapp.backend.receta.Receta;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String mail;
    private String nickname;
    private Boolean habilitado;
    private String nombre;
    private String direccion;
    private String avatar;

    @OneToMany(mappedBy = "usuario")
    private List<Receta> recetas;
}
