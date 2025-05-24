package com.recipeapp.backend.multimedia;

import com.recipeapp.backend.paso.Paso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContenido;

    @ManyToOne
    @JoinColumn(name = "idPaso")
    private Paso paso;

    private String tipoContenido;
    private String extension;
    private String urlContenido;
}
