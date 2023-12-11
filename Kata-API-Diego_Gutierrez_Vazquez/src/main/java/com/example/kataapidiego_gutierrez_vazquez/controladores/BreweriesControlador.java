package com.example.kataapidiego_gutierrez_vazquez.controladores;

import com.example.kataapidiego_gutierrez_vazquez.modelo.Breweries;
import com.example.kataapidiego_gutierrez_vazquez.repositorios.BreweriesRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class BreweriesControlador {

    private final BreweriesRepositorio breweriesRepositorio;

    public BreweriesControlador(BreweriesRepositorio breweriesRepositorio) {
        this.breweriesRepositorio = breweriesRepositorio;
    }

    @GetMapping("/breweries")
    public List<Breweries> getAllBreweries() {
        return breweriesRepositorio.findAll();
    }

    @GetMapping("/breweries/{id}")
    public ResponseEntity<Breweries> getBreweryById(@PathVariable Long id) {
        Optional<Breweries> brewery = breweriesRepositorio.findById(id);

        if (brewery.isPresent()) {
            return ResponseEntity.ok(brewery.get());
        } else {
            throw new RecursoNoEncontradoException("Brewery no encontrada con el id: " + id);
        }
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class RecursoNoEncontradoException extends RuntimeException {
        public RecursoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }
}

