package com.example.kataapidiego_gutierrez_vazquez.repositorios;

import com.example.kataapidiego_gutierrez_vazquez.modelo.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepositorio  extends JpaRepository<Categories, Long> {
}
