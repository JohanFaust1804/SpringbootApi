package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams {

    public void muestraEjemplos(){
        List<String> nombres = Arrays.asList("Brenda", "Luis", "Maria Fernanda", "Eric", "Genesys");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("L"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);

    }

}
