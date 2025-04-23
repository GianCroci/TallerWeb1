package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

@Service
public interface ServicioUsuario {

    void asociarPerfil(String mailUsuario, Long idPerfil);

    Long getPerfilDeUsuario(String mailUsuario);
}
