package com.recipeapp.backend.utilizado;

import com.recipeapp.backend.ingrediente.Ingrediente;
import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.unidad.Unidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilizado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizado;

    @ManyToOne
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;

    private Double cantidad;

    @ManyToOne
    @JoinColumn(name = "idUnidad")
    private Unidad unidad;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta receta;
}
