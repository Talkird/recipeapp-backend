package com.recipeapp.backend.unidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.recipeapp.backend.utilizado.Utilizado;
import com.recipeapp.backend.conversion.Conversion;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidad;
    private String descripcion;

    @OneToMany(mappedBy = "unidad")
    private List<Utilizado> utilizados;

    @OneToMany(mappedBy = "unidadOrigen")
    private List<Conversion> conversionesOrigen;

    @OneToMany(mappedBy = "unidadDestino")
    private List<Conversion> conversionesDestino;
}
