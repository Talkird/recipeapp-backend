package com.recipeapp.backend.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long idCurso) {
        return cursoRepository.findById(idCurso).orElse(null);
    }

    public Curso getCursoByDescription(String descripcion) {
        return cursoRepository.findByDescripcion(descripcion);
    }

    public List<Curso> getCursosByModalidad(String modalidad) {
        return cursoRepository.findByModalidad(modalidad);
    }

    public List<Curso> getCursosBySede(Long idSede) {
        return cursoRepository.findBySedeId(idSede);
    }

    public List<Curso> getCursosWithVacantes() {
        return cursoRepository.findCursosWithVacantes();
    }

    public List<Curso> getCursosWithPromocion() {
        return cursoRepository.findCursosWithPromocion();
    }

    public List<Curso> getCursosOrderByPrecioAsc() {
        return cursoRepository.findAllByOrderByPrecioAsc();
    }

    public List<Curso> getCursosOrderByPrecioDesc() {
        return cursoRepository.findAllByOrderByPrecioDesc();
    }

    public List<Curso> getCursosOrderByDuracionAsc() {
        return cursoRepository.findAllByOrderByDuracionAsc();
    }
    
    public List<Curso> getCursosOrderByDuracionDesc() {
        return cursoRepository.findAllByOrderByDuracionDesc();
    }

    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long idCurso, Curso updatedCurso) {
        return cursoRepository.findById(idCurso).map(existing -> {
            existing.setDescripcion(updatedCurso.getDescripcion());
            existing.setContenidos(updatedCurso.getContenidos());
            existing.setRequerimientos(updatedCurso.getRequerimientos());
            existing.setDuracion(updatedCurso.getDuracion());
            existing.setPrecio(updatedCurso.getPrecio());
            existing.setModalidad(updatedCurso.getModalidad());
            return cursoRepository.save(existing);
        }).orElse(null);
    }

    public void deleteCurso(Long idCurso) {
        cursoRepository.deleteById(idCurso);
    }
}

