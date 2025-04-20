package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Tarea;
import com.tallerwebi.dominio.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ControladorTarea {

    @Autowired
    private TareaService tareaService;


    public ControladorTarea(TareaService servicioTareaMock) {
        this.tareaService = servicioTareaMock;
    }

    @GetMapping("/tareas")
    public ModelAndView verTareas() {

        List<Tarea> tareas = tareaService.obtenerTareas();

        ModelAndView modelAndView = new ModelAndView("tareas");
        modelAndView.addObject("nuevaTarea", new Tarea());
        modelAndView.addObject("tareas", tareas);

        return modelAndView;
    }

    @PostMapping("/tareas")
    public ModelAndView agregarTarea(@ModelAttribute Tarea nuevaTarea) {
        tareaService.agregarTarea(nuevaTarea);

        return new ModelAndView("redirect:/tareas");
    }
}
