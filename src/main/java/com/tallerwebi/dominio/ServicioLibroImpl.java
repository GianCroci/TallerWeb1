package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioLibroImpl implements  ServicioLibro{

    List<Libro> libros = new ArrayList<Libro>(List.of(
            new Libro(1L, "Pinocho", "Carlo Collodi", 1882),
            new Libro(2L, "Blancanieves", "Hermanos Grimm", 1812),
            new Libro(3L, "Minuzzolo", "Carlo Collodi", 1877),
            new Libro(4L, "Adrian y su pelota", "Pascual Hernandez", 1986),
            new Libro(5L, "El secreto de sus ojos", "Eduardo Sacheri", 2009)

    ));

    @Override
    public List<Libro> buscar(String texto) {

        if (texto == null || texto.isEmpty()) {
            return Collections.emptyList();
        }

        return libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(texto.toLowerCase()) ||
                        libro.getAutor().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }


}
