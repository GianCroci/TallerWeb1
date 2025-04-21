package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioLibroImpl implements  ServicioLibro{

    List<Libro> libros = new ArrayList<Libro>(List.of(
            new Libro(1L, "Pinocho", "Carlo Collodi", 1882),
            new Libro(2L, "Blancanieves", "Hermanos Grimm", 1812),
            new Libro(3L, "Minuzzolo", "Carlo Collodi", 1877),
            new Libro(4L, "Adrian y su pelota", "Pascual Hernandez", 1986),
            new Libro(5L, "El secreto de sus ojos", "Eduardo Sacheri", 2009)

    ));

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {

        return libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String buscarPorAutor(String autor) {

        String titulo = "";
        Integer contador = 0;


        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor) && contador == 0) {
                contador = 1;
                titulo = libro.getTitulo();
            }
            else if (contador > 0 && libro.getAutor().equalsIgnoreCase(autor)) {
                titulo += " - " +libro.getTitulo();
            }
        }
        return titulo;
    }
}
