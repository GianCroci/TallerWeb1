package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioUsuarioJuegoImpl;
import com.tallerwebi.dominio.UsuarioJuego;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginJuegoTest {

    @Test
    public void queSePuedaCrearUnUsuarioYDevuelvaUnMensajeDeConfirmacion(){

        //preparacion
        UsuarioJuego usuario = new UsuarioJuego("gian5", "1234");

        ServicioUsuarioJuegoImpl servicioUsuarioImpl = new ServicioUsuarioJuegoImpl();
        ControladorLoginJuego controlador = new ControladorLoginJuego(servicioUsuarioImpl);

        //ejecucion
        ModelAndView modelAndView = controlador.crearUsuario(usuario);

        //verificacion
        String vistaEsperada = "usuario-creado";
        String mensajeEsperado = "Usuario creado correctamente";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));

    }

    @Test
    public void dadoQueElUsuarioYaExisteDevuelveUnMensajeDeError(){
        UsuarioJuego usuario = new UsuarioJuego("gian5", "1234");
        UsuarioJuego usuarioDuplicado = new UsuarioJuego("gian5", "1234");

        ServicioUsuarioJuegoImpl servicioUsuarioImpl = new ServicioUsuarioJuegoImpl();
        ControladorLoginJuego controlador = new ControladorLoginJuego(servicioUsuarioImpl);

        controlador.crearUsuario(usuario);
        ModelAndView modelAndView = controlador.crearUsuario(usuarioDuplicado);

        String vistaEsperada = "usuario-ya-existente";
        String mensajeEsperado = "Usuario ya existente";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(mensajeEsperado, equalTo(modelAndView.getModel().get("mensaje")));

    }
}
