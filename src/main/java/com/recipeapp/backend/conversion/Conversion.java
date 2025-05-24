package com.recipeapp.backend.conversion;

import com.recipeapp.backend.unidad.Unidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConversion;

    @ManyToOne
    @JoinColumn(name = "idUnidadOrigen")
    private Unidad unidadOrigen;

    @ManyToOne
    @JoinColumn(name = "idUnidadDestino")
    private Unidad unidadDestino;

    private Double factorConversion;
}
