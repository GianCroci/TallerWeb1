package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioUsuarioJuegoImpl {

    private List<UsuarioJuego> usuarios = new ArrayList<UsuarioJuego>();

    public Boolean crearUsuario(UsuarioJuego usuario) {

        if (usuarios.size() == 0) {
            usuarios.add(usuario);
            return true;
        }

        for (UsuarioJuego u : usuarios) {
            if(!u.getNombre().equals(usuario.getNombre())) {
                
                usuarios.add(usuario);
                return true;
            }
        }
        return false;
    }
}
