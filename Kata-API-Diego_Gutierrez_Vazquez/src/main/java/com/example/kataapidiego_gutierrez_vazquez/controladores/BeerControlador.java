package com.example.kataapidiego_gutierrez_vazquez.controladores;

import com.example.kataapidiego_gutierrez_vazquez.modelo.Beer;
import com.example.kataapidiego_gutierrez_vazquez.repositorios.BeerRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class BeerControlador {

    private final BeerRepositorio beerRepositorio;

    public BeerControlador(BeerRepositorio beerRepositorio) {
        this.beerRepositorio = beerRepositorio;
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers() {
        return beerRepositorio.findAll();
    }

    @PostMapping("/beer")
    public Beer addBeer(@RequestBody Beer beer) {
        return beerRepositorio.save(beer);
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable Long id) {
        Optional<Beer> beer = beerRepositorio.findById(id);

        if (beer.isPresent()) {
            return ResponseEntity.ok(beer.get());
        } else {
            throw new RecursoNoEncontradoException("Beer no encontrada con el id: " + id);
        }
    }
    public static class RecursoNoEncontradoException extends RuntimeException {
        public RecursoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

        @DeleteMapping("/beer/{id}")
    public void deleteBeer(@PathVariable Long id) {
        beerRepositorio.deleteById(id);
    }

    @PutMapping("/beer/{id}")
    public Beer updateBeer(@PathVariable Long id, @RequestBody Beer updatedBeer) {
        updatedBeer.setId(id);
        return beerRepositorio.save(updatedBeer);
    }

    @PatchMapping("/beer/{id}")
    public Beer partialUpdateBeer(@PathVariable Long id, @RequestBody Beer partialBeer) {
        Optional<Beer> optionalBeer = beerRepositorio.findById(id);
        if (optionalBeer.isPresent()) {
            Beer existingBeer = optionalBeer.get();
            if (partialBeer.getName() != null) {
                existingBeer.setName(partialBeer.getName());
            }
            if (partialBeer.getDescript() != null) {
                existingBeer.setDescript(partialBeer.getDescript());
            }
            return beerRepositorio.save(existingBeer);
        }

        return null;
    }
}