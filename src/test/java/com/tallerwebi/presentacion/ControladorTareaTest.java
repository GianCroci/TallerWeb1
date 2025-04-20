package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioTareaImpl;
import com.tallerwebi.dominio.Tarea;
import com.tallerwebi.dominio.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;


public class ControladorTareaTest {
    private ControladorTarea controladorTarea;
    private TareaService servicioTareaMock;

    @BeforeEach
    public void init() {
        servicioTareaMock = mock(TareaService.class);
        controladorTarea = new ControladorTarea(servicioTareaMock);
    }

    @Test
    public void debeMostrarLaListaDeTareas() {
        List<Tarea> tareasMock = Arrays.asList(
                new Tarea(1L, "Estudiar para el parcial", false),
                new Tarea(2L, "Hacer los Tests", false)
        );
        when(servicioTareaMock.obtenerTareas()).thenReturn(tareasMock);

        ModelAndView modelAndView = controladorTarea.verTareas();

        String vistaEsperada = "tareas";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(modelAndView.getModel().get("tareas"), equalTo(tareasMock));
    }

    @Test
    public void queAlgregarUnaTareaLlameAlServicioYRedirijaAlListado(){
        Tarea nuevaTarea = new Tarea();
        nuevaTarea.setNombre("Preparar la presentacion siguiente");

        ModelAndView modelAndView = controladorTarea.agregarTarea(nuevaTarea);

        verify(servicioTareaMock, times(1)).agregarTarea(nuevaTarea);
        assertThat(modelAndView.getViewName(), equalTo("redirect:/tareas"));

    }
}
