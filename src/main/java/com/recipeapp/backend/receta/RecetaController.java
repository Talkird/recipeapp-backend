package com.recipeapp.backend.receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {
    @Autowired
    private RecetaService recetaService;

    @PostMapping("/create")
    public Receta createReceta(@RequestBody Receta receta) {
        return recetaService.createReceta(receta);
    }

    @GetMapping("/get/{id}")
    public Receta getRecetaById(@PathVariable Long id) {
        return recetaService.getRecetaById(id);
    }

    @GetMapping("/getByNombre/{nombre}")
    public Receta getRecetaByNombre(@PathVariable String nombre) {
        return recetaService.getRecetaByNombre(nombre);
    }

    @GetMapping("/all")
    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    @PutMapping("/update/{id}")
    public Receta updateReceta(@PathVariable Long id, @RequestBody Receta receta) {
        return recetaService.updateReceta(id, receta);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReceta(@PathVariable Long id) {
        recetaService.deleteReceta(id);
    }

    @GetMapping("/tipo/{idTipo}")
    public List<Receta> getRecetasByTipo(@PathVariable Long idTipo) {
        return recetaService.getRecetasByTipoId(idTipo);
    }
}
