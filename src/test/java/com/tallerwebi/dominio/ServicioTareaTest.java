package com.tallerwebi.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ServicioTareaTest {

    private ServicioTareaImpl servicioTarea;

    @BeforeEach
    public void setUp() {
        servicioTarea = new ServicioTareaImpl();
    }

    @Test
    public void queSePuedaAgregarUnaTarea() {
        Tarea tarea = new Tarea(1L, "Estudiar para el parcial", false);

        servicioTarea.agregarTarea(tarea);

        List<Tarea> listadoTareas = (List<Tarea>)servicioTarea.obtenerTareas();

        assertThat(1, equalTo(listadoTareas.size()));
    }

    @Test
    public void queSePuedaCompletarUnaTarea() {
        Tarea tarea = new Tarea(1L, "Estudiar para el parcial", false);

        servicioTarea.agregarTarea(tarea);
        servicioTarea.marcarComoCompletada(1L);

        List<Tarea> listadoTareas = (List<Tarea>)servicioTarea.obtenerTareas();

        assertThat(true, equalTo(listadoTareas.get(0).getEstaHecha()));
    }

    @Test
    public void queSePuedanObtenerTodasLasTareas() {
        Tarea tarea1 = new Tarea(1L, "Estudiar para el parcial", false);
        Tarea tarea2 = new Tarea(2L, "Hacer los Tests", false);
        Tarea tarea3 = new Tarea(3L, "Leer la documentacion", false);
        servicioTarea.agregarTarea(tarea1);
        servicioTarea.agregarTarea(tarea2);
        servicioTarea.agregarTarea(tarea3);

        List<Tarea> listadoTareas = (List<Tarea>)servicioTarea.obtenerTareas();

        assertThat(3, equalTo(listadoTareas.size()));
        assertThat("Hacer los Tests", equalTo(listadoTareas.get(1).getNombre()));

    }
}
