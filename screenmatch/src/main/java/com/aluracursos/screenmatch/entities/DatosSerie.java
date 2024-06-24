package com.aluracursos.screenmatch.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons")Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
<<<<<<< HEAD
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors") String actores,
        @JsonAlias("Plot") String sinopsis){
=======
        @JsonAlias("Poster")String poster,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors")String actores,
        @JsonAlias("Plot")String sinopsis){


>>>>>>> 68e7887bfe8bf448e3b3475fe7b14d0cbc43fb83
}
