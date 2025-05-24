package com.recipeapp.backend.receta;

import jakarta.persistence.*;
import java.util.List;

import com.recipeapp.backend.calificacion.Calificacion;
import com.recipeapp.backend.foto.Foto;
import com.recipeapp.backend.multimedia.Multimedia;
import com.recipeapp.backend.paso.Paso;
import com.recipeapp.backend.tiporeceta.TipoReceta;
import com.recipeapp.backend.usuario.Usuario;
import com.recipeapp.backend.utilizado.Utilizado;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String nombreReceta;
    private String descripcionReceta;
    private String fotoPrincipal;
    private Integer porciones;
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoReceta tipo;

    @OneToMany(mappedBy = "receta")
    private List<Paso> pasos;

    @OneToMany(mappedBy = "receta")
    private List<Utilizado> utilizados;

    @OneToMany(mappedBy = "receta")
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "receta")
    private List<Foto> fotos;

    @OneToMany(mappedBy = "receta")
    private List<Multimedia> multimedia;
}
