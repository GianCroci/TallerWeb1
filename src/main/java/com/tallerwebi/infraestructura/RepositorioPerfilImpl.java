package com.tallerwebi.infraestructura;

import com.tallerwebi.dominio.Perfil;
import org.springframework.stereotype.Repository;

@Repository("repositorioPerfil")
public class RepositorioPerfilImpl implements RepositorioPerfil {
    @Override
    public Perfil buscar(Long idPerfil) {
        return null;
    }
}
