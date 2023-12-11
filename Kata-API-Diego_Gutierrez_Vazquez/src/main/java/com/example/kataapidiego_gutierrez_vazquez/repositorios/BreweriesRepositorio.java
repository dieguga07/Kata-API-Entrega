package com.example.kataapidiego_gutierrez_vazquez.repositorios;


import com.example.kataapidiego_gutierrez_vazquez.modelo.Breweries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreweriesRepositorio  extends JpaRepository<Breweries, Long> {


}
