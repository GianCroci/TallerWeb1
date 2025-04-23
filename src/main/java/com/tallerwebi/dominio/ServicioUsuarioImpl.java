package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioPerfil repositorioPerfil;
    private RepositorioUsuario repositorioUsuario;

    Map<String, Long> asociacionUsuarioPerfil = new HashMap<>();


    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario, RepositorioPerfil repositorioPerfil) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPerfil = repositorioPerfil;
    }


    @Override
    public void asociarPerfil(String mailUsuario, Long idPerfil) {
        asociacionUsuarioPerfil.put(mailUsuario, idPerfil);
    }

    @Override
    public Long getPerfilDeUsuario(String mailUsuario) {
        Long idPerfil = asociacionUsuarioPerfil.get(mailUsuario);
        return idPerfil;
    }
}
