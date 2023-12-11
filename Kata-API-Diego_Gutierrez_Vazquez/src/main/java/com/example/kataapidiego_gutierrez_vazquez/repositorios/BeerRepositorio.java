package com.example.kataapidiego_gutierrez_vazquez.repositorios;

import com.example.kataapidiego_gutierrez_vazquez.modelo.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepositorio extends JpaRepository<Beer, Long> {
    List<Beer> findAllById(Long beerId);
}
