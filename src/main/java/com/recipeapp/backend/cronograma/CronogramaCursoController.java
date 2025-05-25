package com.recipeapp.backend.cronograma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cronogramas")
public class CronogramaCursoController {

    @Autowired
    private CronogramaCursoService cronogramaCursoService;

    @GetMapping
    public List<CronogramaCurso> getAllCronogramas() {
        return cronogramaCursoService.getAllCronogramas();
    }

    @GetMapping("/{id}")
    public CronogramaCurso getCronogramaById(@PathVariable Long id) {
        return cronogramaCursoService.getCronogramaById(id);
    }
    
    @GetMapping("/fechaInicio")
    public List<CronogramaCurso> getCronogramasByFechaInicio(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio) {
        return cronogramaCursoService.getCronogramasByFechaInicio(fechaInicio);
    }
    
    @GetMapping("/fechaFin")
    public List<CronogramaCurso> getCronogramasByFechaFin(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        return cronogramaCursoService.getCronogramasByFechaFin(fechaFin);
    }
    
    @GetMapping("/fechaInicioBetween")
    public List<CronogramaCurso> getCronogramasByFechaInicioBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return cronogramaCursoService.getCronogramasByFechaInicioBetween(startDate, endDate);
    }
    
    @GetMapping("/fechaFinBetween")
    public List<CronogramaCurso> getCronogramasByFechaFinBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return cronogramaCursoService.getCronogramasByFechaFinBetween(startDate, endDate);
    }
    
    @GetMapping("/sede/{idSede}")
    public List<CronogramaCurso> getCronogramasBySedeId(@PathVariable Long idSede) {
        return cronogramaCursoService.getCronogramasBySedeId(idSede);
    }
    
    @GetMapping("/curso/{idCurso}")
    public List<CronogramaCurso> getCronogramasByCursoId(@PathVariable Long idCurso) {
        return cronogramaCursoService.getCronogramasByCursoId(idCurso);
    }
    
    @GetMapping("/curso/{idCurso}/sede/{idSede}")
    public List<CronogramaCurso> getCronogramasByCursoIdAndSedeId(@PathVariable Long idCurso, @PathVariable Long idSede) {
        return cronogramaCursoService.getCronogramasByCursoIdAndSedeId(idCurso, idSede);
    }
    
    @GetMapping("/fechaInicioBetween/sede/{idSede}")
    public List<CronogramaCurso> getCronogramasByFechaInicioBetweenAndSedeId(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                                                @PathVariable Long idSede) {
        return cronogramaCursoService.getCronogramasByFechaInicioBetweenAndSedeId(startDate, endDate, idSede);
    }
    
    @GetMapping("/fechaInicioBetween/curso/{idCurso}")
    public List<CronogramaCurso> getCronogramasByFechaInicioBetweenAndCursoId(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                                                 @PathVariable Long idCurso) {
        return cronogramaCursoService.getCronogramasByFechaInicioBetweenAndCursoId(startDate, endDate, idCurso);
    }
    
    @PostMapping
    public CronogramaCurso createCronograma(@RequestBody CronogramaCurso cronograma) {
        return cronogramaCursoService.saveCronograma(cronograma);
    }
    
    @PutMapping("/{id}")
    public CronogramaCurso updateCronograma(@PathVariable Long id, @RequestBody CronogramaCurso cronograma) {
        return cronogramaCursoService.updateCronograma(id, cronograma);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCronograma(@PathVariable Long id) {
        cronogramaCursoService.deleteCronograma(id);
    }
}