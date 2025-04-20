package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Contacto;
import com.tallerwebi.dominio.ServicioContactoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ControladorContactoTest {

    @Test
    public void cuandoEnvioElFormularioMeDevuelveUnaVistaDeConfirmacion() {
        Contacto contacto = new Contacto();

        ServicioContactoImpl servicioContacto = new ServicioContactoImpl();
        ControladorContacto controladorContacto = new ControladorContacto(servicioContacto);

        ModelAndView modelAndView = controladorContacto.procesarFormulario(contacto);

        String vistaEsperada = "confirmacion";
        String mensajeEsperado = "Gian su mensaje fue recibido";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));
    }
}
