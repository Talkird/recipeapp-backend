package com.recipeapp.backend.sede;

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
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSede;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private String mailSede;
    private String whatsapp;
    private String tipoBonificacion;
    private String bonificacionCursos;
    private String spPromocion;
    private String promocionCursos;

    @OneToMany(mappedBy = "sede")
    private List<CronogramaCurso> cronogramas;
}
