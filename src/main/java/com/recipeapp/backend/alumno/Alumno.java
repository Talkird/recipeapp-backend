package com.recipeapp.backend.alumno;

import com.recipeapp.backend.asistencia.AsistenciaCurso;
import com.recipeapp.backend.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;
    private String numeroTarjeta;
    private String dniFrente;
    private String dniFondo;
    private String tramite;
    private String cuentaCorriente;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idAsistenciaCurso")
    private AsistenciaCurso asistenciaCurso;
}
