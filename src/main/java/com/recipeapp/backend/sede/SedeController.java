package com.recipeapp.backend.sede;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sedes")
public class SedeController  {
    
    @Autowired
    SedeService sedeService;

    @GetMapping("/all")
    public List<Sede> getAllSedes() {
        return sedeService.getAllSedes();
    }

    @DeleteMapping("/remove/{idSede}")
    public void removeSede(Long idSede) {
        sedeService.removeSede(idSede);
    }

    @GetMapping("/get/{idSede}")
    public Sede getSede(Long idSede) {
        return sedeService.getSede(idSede);
    }

    @GetMapping("/getByNombre/{nombreSede}")
    public Sede getSedeByNombre(String nombreSede) {
        return sedeService.getSedeByNombre(nombreSede);
    }

    @PostMapping("/add")
    public void addSede(Sede sede) {
        sedeService.addSede(sede);
    }

}
