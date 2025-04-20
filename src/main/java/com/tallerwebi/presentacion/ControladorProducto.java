package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Producto;
import com.tallerwebi.dominio.ServicioProductoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorProducto {

    @Autowired
    private ServicioProductoImpl servicioProducto;

    public ControladorProducto(ServicioProductoImpl servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @GetMapping("/productos")
    public ModelAndView listarProductos() {
        List<Producto> productos = new ArrayList<>(List.of(
                new Producto(1L, "Leche", "Lacteos", 1300),
                new Producto(2L, "Entraña", "Carniceria", 12000),
                new Producto(3L, "Pan", "Panaderia", 2000)
        ));

        ModelMap modelMap = new ModelMap();
        modelMap.put("productos", productos);
        return new ModelAndView("productos", modelMap);
    }

    @GetMapping("/productos/{id}")
    public ModelAndView verDetalle(@PathVariable Long id) {
        List<Producto> productos = new ArrayList<>(List.of(
                new Producto(1L, "Leche", "Lacteos", 1300),
                new Producto(2L, "Entraña", "Carniceria", 12000),
                new Producto(3L, "Pan", "Panaderia", 2000)
        ));

        Producto productoEncontrado = productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        ModelMap modelMap = new ModelMap();
        modelMap.put("producto", productoEncontrado);

        return new ModelAndView("detalle", modelMap);
    }
}
