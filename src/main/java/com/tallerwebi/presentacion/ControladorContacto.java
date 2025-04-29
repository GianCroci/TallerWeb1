package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.Contacto;
import com.tallerwebi.dominio.ServicioContactoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorContacto {

    @Autowired
    private ServicioContactoImpl servicioContacto;

    public ControladorContacto(ServicioContactoImpl servicioContacto) {
        this.servicioContacto = servicioContacto;
    }

    @GetMapping("/contacto")
    public ModelAndView irAlFormulario(){
        ModelMap modelMap = new ModelMap();
        modelMap.put("datosContacto", new Contacto());
        return new ModelAndView ("contacto", modelMap);
    }


    @PostMapping("/contacto")
    public ModelAndView procesarFormulario(@ModelAttribute("datosContacto") Contacto contacto) {

        ModelMap modelMap = new ModelMap();
        modelMap.put("datosContacto", contacto);
        modelMap.put("mensaje", "su mensaje fue recibido");

        return new ModelAndView("confirmacion", modelMap);
    }
}
