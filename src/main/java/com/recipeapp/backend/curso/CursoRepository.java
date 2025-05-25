package com.recipeapp.backend.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByDescripcion(String descripcion);
    List <Curso> findByModalidad(String modalidad);
    List<Curso> findAllByOrderByPrecioAsc();
    List<Curso> findAllByOrderByPrecioDesc();
    List<Curso> findAllByOrderByDuracionAsc(); 
    List<Curso> findAllByOrderByDuracionDesc();
    
    @Query("SELECT DISTINCT c FROM Curso c JOIN c.cronogramas cr WHERE cr.sede.idSede = :idSede")
    List<Curso> findBySedeId(@Param("idSede") Long idSede);
    
    @Query("SELECT DISTINCT c FROM Curso c JOIN c.cronogramas cr WHERE cr.vacantesDisponibles > 0")
    List<Curso> findCursosWithVacantes();

    @Query("SELECT DISTINCT c FROM Curso c JOIN c.cronogramas cr JOIN cr.sede s WHERE s.promocion IS NOT NULL")
    List<Curso> findCursosWithPromocion();

}

