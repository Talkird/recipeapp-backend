package com.recipeapp.backend.multimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multimedia")
public class MultimediaController {
    @Autowired
    private MultimediaService multimediaService;

    @GetMapping
    public List<Multimedia> getAllMultimedia() {
        return multimediaService.getAllMultimedia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Multimedia> getMultimediaById(@PathVariable Long id) {
        return multimediaService.getMultimediaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Multimedia createMultimedia(@RequestBody Multimedia multimedia) {
        return multimediaService.saveMultimedia(multimedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMultimedia(@PathVariable Long id) {
        multimediaService.deleteMultimedia(id);
        return ResponseEntity.noContent().build();
    }
}
