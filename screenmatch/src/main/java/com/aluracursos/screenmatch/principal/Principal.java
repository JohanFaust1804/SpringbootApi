
package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.entities.DatosEpisodio;
import com.aluracursos.screenmatch.entities.DatosSerie;
import com.aluracursos.screenmatch.entities.DatosTemporada;
import com.aluracursos.screenmatch.entities.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=4fc7c187";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu(){
        System.out.println("Escribe el nombre de la série que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL + nombreSerie.replace(" ", "+") + APIKEY);
        //https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalTemporadas(); i++) {
            json = consumoAPI.obtenerDatos(URL + nombreSerie.replace(" ", "+") + "&Season=" + i + APIKEY);
            DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);

        /*for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }*/

        //mejoria usando funciones de lambda
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista de tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
            .flatMap( t -> t.episodios().stream())
                .collect(Collectors.toList());

        //Top 5 episodies
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primer filtro N/A" + e) )
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("Segundo ordenacion (M>m)" + e) )
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Tercer filtro mayuscula (m>M)" + e) )
                .limit(5)
                .forEach(System.out::println);

        //Convertir todas las informaciones a una lista de tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("Por favor indica el año del cual deseas buscar el episodio");
        var fecha  = teclado.nextLine();
        LocalDate fechaBusqueda = LocalDate.of(Integer.parseInt(fecha), 1, 1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getFechadeLanzamiento() != null && e.getFechadeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                    "Temporada" + e.getTemporada() +
                            "Titulo" + e.getTitulo() +
                            "Fecha de lanzamiento de episodio" + e.getFechadeLanzamiento().format(dateTimeFormatter)
                ));

        //Busca episodios por pedazo del titulo
        System.out.println("Por favor escribe el pedazo de el episodio que deseas buscar");
        var pedazoEpisodio = teclado.nextLine();
        Optional <Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoEpisodio))
                .findFirst();
        if(episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado");
            System.out.println("Los datos son: "+ episodioBuscado.get());
        } else {
            System.out.println("Episodio no encontrado");
        }

        Map <Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e -> e.getEvaluacion() )
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::gsaaqweer¿pkmzmsak}dkañsdkkqqewjjDsaq1234556768989'¿cetEvaluacion)));

        System.out.println(evaluacionesPorTemporada);
    }
}