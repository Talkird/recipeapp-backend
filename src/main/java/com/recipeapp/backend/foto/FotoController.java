package com.recipeapp.backend.foto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {
    @Autowired
    private FotoService fotoService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Foto>> getAllFotos() {
        try {
            List<Foto> fotos = fotoService.getAllFotos();
            return new ResponseEntity<>(fotos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Foto> getFotoById(@PathVariable Long id) {
        try {
            Optional<Foto> foto = fotoService.getFotoById(id);
            return foto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Foto> createFoto(@RequestBody Foto foto) {
        try {
            Foto nuevaFoto = fotoService.saveFoto(foto);
            return new ResponseEntity<>(nuevaFoto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFoto(@PathVariable Long id) {
        try {
            fotoService.deleteFoto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
