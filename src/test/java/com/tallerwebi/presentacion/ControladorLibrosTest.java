package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Libro;
import com.tallerwebi.dominio.ServicioLibroImpl;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ControladorLibrosTest {

    @Test
    public void queDevuelvaUnaVistaConLaBusquedaDeLibros(){
        Libro libro = new Libro();
        libro.setTitulo("Pinocho");
        ServicioLibroImpl servicioLibro = new ServicioLibroImpl();
        ControladorLibro controladorLibro = new ControladorLibro(servicioLibro);

        ModelAndView modelAndView = controladorLibro.buscar(libro);

        String vistaEsperada = "buscar";

        assertThat(modelAndView.getViewName(), equalTo(vistaEsperada));

    }

}
