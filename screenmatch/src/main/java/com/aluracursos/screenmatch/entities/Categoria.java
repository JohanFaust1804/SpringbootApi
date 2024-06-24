package com.aluracursos.screenmatch.entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonAlias;

public enum Categoria {

=======
public enum Categoria {
>>>>>>> 68e7887bfe8bf448e3b3475fe7b14d0cbc43fb83
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIMEN("Crime");

    private String categoriaOmdb;
    Categoria (String categoriaOmdb){
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
