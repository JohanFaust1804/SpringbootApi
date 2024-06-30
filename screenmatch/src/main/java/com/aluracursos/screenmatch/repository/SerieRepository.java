package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.entities.Categoria;
import com.aluracursos.screenmatch.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface SerieRepository extends JpaRepository<Serie,Long> {
        Optional<Serie> findByTituloContainingIgnoreCase(String nombreSerie);
        List<Serie> findTop5ByOrderByEvaluacionDesc();
        List<Serie> findByGenero(Categoria categoria);
        List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);




    }


