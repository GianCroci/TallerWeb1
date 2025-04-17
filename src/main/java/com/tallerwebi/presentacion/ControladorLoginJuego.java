package com.tallerwebi.presentacion;

import com.tallerwebi.dominio.ServicioUsuarioJuegoImpl;
import com.tallerwebi.dominio.UsuarioJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorLoginJuego {

    private ServicioUsuarioJuegoImpl servicioUsuarioJuego;

    @Autowired
    public ControladorLoginJuego(ServicioUsuarioJuegoImpl servicioUsuarioImpl) {
        this.servicioUsuarioJuego = servicioUsuarioImpl;
    }


    @RequestMapping
    public ModelAndView crearUsuario(UsuarioJuego usuario) {
        ModelMap modelMap = new ModelMap();

        Boolean creado = servicioUsuarioJuego.crearUsuario(usuario);

        String mensaje = "Usuario creado correctamente";
        String vista = "usuario-creado";

        if(creado.equals(false)) {
            mensaje = "Usuario ya existente";
            vista = "usuario-ya-existente";
        }

        modelMap.put("mensaje", mensaje);

        return new ModelAndView(vista, modelMap);
    }
}

