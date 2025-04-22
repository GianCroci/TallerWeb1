package com.tallerwebi.dominio;

import java.util.List;

public interface ServicioLibro {
    List<Libro> buscar(String texto);
}
