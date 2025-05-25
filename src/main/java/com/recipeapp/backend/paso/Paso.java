package com.recipeapp.backend.paso;

import com.recipeapp.backend.receta.Receta;
import com.recipeapp.backend.multimedia.Multimedia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaso;

    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta receta;

    private Integer nroPaso;
    private String texto;

    @OneToMany(mappedBy = "paso")
    private List<Multimedia> multimedia;
}
