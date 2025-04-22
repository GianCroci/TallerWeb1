package com.tallerwebi.dominio;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ServicioLibroTest {

    @Test
    public void queSePuedaBuscarUnLibroPorElTituloOPorElAutor() {

        ServicioLibroImpl servicioLibro = new ServicioLibroImpl();
        List<Libro> resultado = servicioLibro.buscar("Collodi");
        String libroEsperado1 = "Pinocho";
        String libroEsperado2 = "Minuzzolo";

        assertThat(libroEsperado1, equalTo(resultado.get(0).getTitulo()));
        assertThat(libroEsperado2, equalTo(resultado.get(1).getTitulo()));
        assertThat(2, equalTo(resultado.size()));
    }

    @Test
    public void queNoSeDevuelvanResultadosSiLaBusquedaEstaVacia(){
        ServicioLibroImpl servicioLibro = new ServicioLibroImpl();
        List<Libro> resultado = servicioLibro.buscar("");

        assertThat(resultado.isEmpty(), equalTo(true));
    }


}
