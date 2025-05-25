package com.recipeapp.backend.conversion;

import com.recipeapp.backend.unidad.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conversions")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping
    public List<Conversion> getAllConversions() {
        return conversionService.getAllConversions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conversion> getConversionById(@PathVariable Long id) {
        Optional<Conversion> conversion = conversionService.getConversionById(id);
        return conversion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conversion createConversion(@RequestBody Conversion conversion) {
        return conversionService.saveConversion(conversion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversion(@PathVariable Long id) {
        conversionService.deleteConversion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculateConversion(@RequestParam Double cantidad, @RequestParam Long idUnidadOrigen,
            @RequestParam Long idUnidadDestino) {
        Unidad unidadOrigen = new Unidad();
        unidadOrigen.setIdUnidad(idUnidadOrigen);
        Unidad unidadDestino = new Unidad();
        unidadDestino.setIdUnidad(idUnidadDestino);

        Optional<Double> resultado = conversionService.calculateConversion(cantidad, unidadOrigen, unidadDestino);
        return resultado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
