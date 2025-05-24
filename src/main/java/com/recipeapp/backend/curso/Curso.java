package com.recipeapp.backend.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.recipeapp.backend.cronograma.CronogramaCurso;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String descripcion;
    private String contenidos;
    private String requerimientos;
    private String duracion;
    private Double precio;
    private String modalidad;

    @OneToMany(mappedBy = "curso")
    private List<CronogramaCurso> cronogramas;
}
