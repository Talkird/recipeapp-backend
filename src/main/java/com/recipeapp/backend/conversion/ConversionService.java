package com.recipeapp.backend.conversion;

import com.recipeapp.backend.unidad.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversionService {

    @Autowired
    private ConversionRepository conversionRepository;

    public List<Conversion> getAllConversions() {
        return conversionRepository.findAll();
    }

    public Optional<Conversion> getConversionById(Long id) {
        return conversionRepository.findById(id);
    }

    public Conversion saveConversion(Conversion conversion) {
        return conversionRepository.save(conversion);
    }

    public void deleteConversion(Long id) {
        conversionRepository.deleteById(id);
    }

    public Optional<Double> calculateConversion(Double cantidad, Unidad unidadOrigen, Unidad unidadDestino) {
        Optional<Conversion> conversion = conversionRepository.findByUnidadOrigenAndUnidadDestino(unidadOrigen,
                unidadDestino);
        return conversion.map(c -> cantidad * c.getFactorConversion());
    }
}
