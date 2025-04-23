package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Libro;
import com.tallerwebi.dominio.ServicioLibro;
import com.tallerwebi.dominio.ServicioLibroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorLibro {

    @Autowired
    private ServicioLibro servicioLibro;

    public ControladorLibro(ServicioLibroImpl servicioLibro) {
        this.servicioLibro = servicioLibro;
    }


    @GetMapping("buscar")
    public ModelAndView irAlFormulario() {

        ModelMap modelMap = new ModelMap();
        modelMap.put("datosLibros", new Libro());
        modelMap.put("resultados", null);

        return new ModelAndView("buscar", modelMap);
    }

    @PostMapping("buscar")
    public ModelAndView buscar(@ModelAttribute("datosLibros") Libro libro) {

        String texto = libro.getTitulo();
        List<Libro> resultados = servicioLibro.buscar(texto);

        ModelMap modelMap = new ModelMap();
        modelMap.put("datosLibros", libro);
        modelMap.put("resultados", resultados);


        return new ModelAndView("buscar", modelMap);
    }


}
