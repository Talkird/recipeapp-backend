package com.recipeapp.backend.cronograma;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import com.recipeapp.backend.asistencia.AsistenciaCurso;
import com.recipeapp.backend.curso.Curso;
import com.recipeapp.backend.sede.Sede;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CronogramaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCronograma;

    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private Integer vacantesDisponibles;

    @OneToMany(mappedBy = "cronograma")
    private List<AsistenciaCurso> asistencias;
}
