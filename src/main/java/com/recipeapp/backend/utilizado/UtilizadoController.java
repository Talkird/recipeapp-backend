package com.recipeapp.backend.utilizado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilizados")
public class UtilizadoController {
    @Autowired
    private UtilizadoService utilizadoService;

    @GetMapping("/get/all")
    public List<Utilizado> getAll() {
        return utilizadoService.findAll();
    }

    @GetMapping("/get/{id}")
    public Utilizado getById(@PathVariable Long id) {
        return utilizadoService.findById(id);
    }

    @PostMapping("/create")
    public Utilizado create(@RequestBody Utilizado utilizado) {
        return utilizadoService.save(utilizado);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        utilizadoService.deleteById(id);
    }
}
