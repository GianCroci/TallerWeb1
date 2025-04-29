package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioPerfil repositorioPerfil;
    private RepositorioUsuario repositorioUsuario;
    private Usuario usuario;

    Map<String, Long> asociacionUsuarioPerfil = new HashMap<>();



    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario, RepositorioPerfil repositorioPerfil) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPerfil = repositorioPerfil;
    }


    @Override
    public Long getPerfilDeUsuario(String mailUsuario) {
       Usuario usuario = repositorioUsuario.buscar(mailUsuario);
       return usuario.getPerfilAsociado().getId();
    }

    @Override
    public void asociarPerfil(String mailUsuario, Long idPerfil) {
        Usuario usuario = repositorioUsuario.buscar(mailUsuario);
        Perfil perfil = repositorioPerfil.buscar(idPerfil);
        usuario.setPerfil(perfil);
        perfil.setUsuario(usuario);
    }


}
