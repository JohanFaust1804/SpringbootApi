package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ScreenmatchApplicationConsola implements ComandLineRunner {

    @Autowired
    private SerieRepository serieRepository;

    public static void main(String ... args)

}
