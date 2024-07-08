package com.aluracursos.screenmatch.dto;

import com.aluracursos.screenmatch.entities.Categoria;

public record SerieDTO( Long id,
                        String titulo,
                        Integer totalTemporadasm,
                        Double evaluacion,
                        String poster,
                        Categoria genero,

                        String actores,

                        String sinopsis) {
}
