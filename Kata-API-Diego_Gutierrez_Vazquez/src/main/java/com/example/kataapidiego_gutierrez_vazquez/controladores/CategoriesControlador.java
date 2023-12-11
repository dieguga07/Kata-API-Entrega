package com.example.kataapidiego_gutierrez_vazquez.controladores;

import com.example.kataapidiego_gutierrez_vazquez.modelo.Categories;
import com.example.kataapidiego_gutierrez_vazquez.repositorios.CategoriesRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CategoriesControlador {

    private final CategoriesRepositorio categoriesRepositorio;

    public CategoriesControlador(CategoriesRepositorio categoriesRepositorio) {
        this.categoriesRepositorio = categoriesRepositorio;
    }

    @GetMapping("/categories")
    public List<Categories> getAllCategories() {
        return categoriesRepositorio.findAll();
    }

    @GetMapping("/categorie/{id}")
    public Optional<Categories> getCategoryById(@PathVariable Long id) {
        return categoriesRepositorio.findById(id);
    }
}
