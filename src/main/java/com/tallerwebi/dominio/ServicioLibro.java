package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioLibro {
    List<Libro> buscarPorTitulo(String pinocho);

    String buscarPorAutor(String carloCollodi);
}
