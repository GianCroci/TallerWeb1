package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

@Service
public interface ServicioUsuario {

    Long getPerfilDeUsuario(String mailUsuario);

    void asociarPerfil(String mailUsuario, Long idPerfil);
}
