package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioPerfil;
import org.springframework.stereotype.Service;

@Service
public class ServicioPerfilImpl implements ServicioPerfil {

    private RepositorioPerfil repositorioPerfil;
    private RepositorioUsuario repositorioUsuario;

    public ServicioPerfilImpl(RepositorioUsuario repositorioUsuario, RepositorioPerfil repositorioPerfil) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPerfil = repositorioPerfil;
    }

    @Override
    public Perfil getMailUsuarioAsociado(Long idPerfil) {
        Perfil perfil = repositorioPerfil.buscar(idPerfil);
        return perfil;
    }
}
