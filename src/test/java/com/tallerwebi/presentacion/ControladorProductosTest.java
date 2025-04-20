package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Producto;
import com.tallerwebi.dominio.ServicioProductoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ControladorProductosTest {

    @Test
    public void queSeDevuelvaUnaListaDeProductos() {
        ServicioProductoImpl servicioProducto = new ServicioProductoImpl();
        ControladorProducto controladorProducto = new ControladorProducto(servicioProducto);

        ModelAndView modelAndView = controladorProducto.listarProductos();

        List<Producto> productos = (List<Producto>) modelAndView.getModel().get("productos");

        String vistaEsperada = "productos";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
        assertThat(3, equalTo(productos.size()));
        assertThat("Leche", equalTo(productos.get(0).getNombre()));
    }

    @Test
    public void queSeDevuelvaUnaVistaDeDetalle(){
        Long idBuscado = 1L;
        Producto productoEsperado = new Producto(1L, "Leche", "Lacteos", 1300);

        ServicioProductoImpl servicioProducto = new ServicioProductoImpl();
        ControladorProducto controladorProducto = new ControladorProducto(servicioProducto);

        ModelAndView modelAndView = controladorProducto.verDetalle(idBuscado);

        String vistaEsperada = "detalle";

        assertThat(vistaEsperada, equalTo(modelAndView.getViewName()));
    }



}
