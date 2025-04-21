package com.tallerwebi.dominio;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ServicioLibroTest {

    @Test
    public void queSePuedaBuscarUnLibroPorElTitulo() {

        ServicioLibroImpl servicioLibro = new ServicioLibroImpl();
        List<Libro> resultado = servicioLibro.buscarPorTitulo("Pinocho");
        String libroEsperado = "Pinocho";

        assertThat(libroEsperado, equalTo(resultado.get(0).getTitulo()));
        assertThat(1, equalTo(resultado.size()));
    }

    @Test
    public void queSePuedaFiltrarPorAutor(){
        ServicioLibroImpl servicioLibro = new ServicioLibroImpl();


        String libroEsperado = "Pinocho - Minuzzolo";

        String libroRecibido = servicioLibro.buscarPorAutor("Carlo Collodi");

        assertThat(libroEsperado, equalTo(libroRecibido));
    }
}
