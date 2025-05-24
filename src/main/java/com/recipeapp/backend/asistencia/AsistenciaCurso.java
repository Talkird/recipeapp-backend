package com.recipeapp.backend.asistencia;

import com.recipeapp.backend.alumno.Alumno;
import com.recipeapp.backend.cronograma.CronogramaCurso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;

    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idCronograma")
    private CronogramaCurso cronograma;

    @Temporal(TemporalType.DATE)
    private java.util.Date fecha;
}
