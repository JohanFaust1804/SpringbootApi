
package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.entities.*;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
<<<<<<< HEAD
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=4fc7c187";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosSerie> datosSeries = new ArrayList<>();
    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {

            var menu = """
                    1 - Buscar series
                    2 - Buscar episodios
                    3 - Mostrar Series buscadas
                                            
                    0 - Salir 
=======
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "TU-APIKEY-OMDB";
    private ConvierteDatos conversor = new ConvierteDatos();
    private List<DatosSerie> datosSeries = new ArrayList<>();

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                                  
                    0 - Salir
>>>>>>> 68e7887bfe8bf448e3b3475fe7b14d0cbc43fb83
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
<<<<<<< HEAD

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;

                case 2:
                    buscarEpisodioPorSerie();
                    break;

                case 3:
                    mostrarSeriesBuscadas();
                    break;

                case 0:
                    System.out.println("Saliendo de el menú");
                    break;

                default:
                    System.out.println("Opción inválida");

            }
        }
    }

    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }
    private void buscarEpisodioPorSerie() {
        DatosSerie datosSerie = getDatosSerie();
        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datosSerie.totalTemporadas(); i++) {
            var json = consumoAPI.obtenerDatos(URL_BASE + datosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);
    }
    private void buscarSerieWeb() {
        DatosSerie datos = getDatosSerie();
        datosSeries.add(datos);
        System.out.println(datos);
    }

    private void mostrarSeriesBuscadas() {
        List<Serie> series = new ArrayList<>();
        series = datosSeries.stream()
                .map(d -> new Serie(d))
                .collect(Collectors.toList());

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }
}

=======

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        private DatosSerie getDatosSerie () {
            System.out.println("Escribe el nombre de la serie que deseas buscar");
            var nombreSerie = teclado.nextLine();
            var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
            System.out.println(json);
            DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
            return datos;
        }
        private void buscarEpisodioPorSerie () {
            DatosSerie datosSerie = getDatosSerie();
            List<DatosTemporadas> temporadas = new ArrayList<>();

            for (int i = 1; i <= datosSerie.totalTemporadas(); i++) {
                var json = consumoApi.obtenerDatos(URL_BASE + datosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);
        }
        private void buscarSerieWeb() {
            DatosSerie datos = getDatosSerie();
            datosSeries.add(datos);
            System.out.println(datos);
        }

        private void mostrarSeriesBuscadas () {
            List<Serie> series = new ArrayList<>();
            series = datosSeries.stream()
                    .map(d -> new Serie(d))
                    .collect(Collectors.toList());

            series.stream()
                    .sorted(Comparator.comparing(Serie::getGenero))
                    .forEach(System.out::println);
        }
    }
}
>>>>>>> 68e7887bfe8bf448e3b3475fe7b14d0cbc43fb83
