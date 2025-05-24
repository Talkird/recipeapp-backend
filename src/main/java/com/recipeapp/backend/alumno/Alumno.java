package com.recipeapp.backend.alumno;

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
}
