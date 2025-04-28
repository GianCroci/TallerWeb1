package com.tallerwebi.dominio;

import com.tallerwebi.infraestructura.RepositorioPerfil;
import com.tallerwebi.infraestructura.RepositorioPerfilImpl;
import com.tallerwebi.infraestructura.RepositorioUsuarioImpl;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest {

    @Test
    public void queSePuedaAsociarUnPerfilAUnUsuario(){
        RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
        RepositorioPerfil repositorioPerfil = mock(RepositorioPerfil.class);

        Usuario usuario = new Usuario();
        String mailUsuario = "test@gmail.com";
        usuario.setEmail(mailUsuario);

        Perfil perfil = new Perfil();
        Long idPerfil = 50L;
        perfil.setId(50L);

        when(repositorioUsuario.buscar(mailUsuario)).thenReturn(usuario);
        when(repositorioPerfil.buscar(idPerfil)).thenReturn(perfil);

        ServicioUsuario servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario, repositorioPerfil);
        ServicioPerfil servicioPerfil = new ServicioPerfilImpl(repositorioUsuario, repositorioPerfil);

        servicioUsuario.asociarPerfil(mailUsuario, idPerfil);

        assertThat(servicioUsuario.getPerfilDeUsuario(mailUsuario), equalTo(idPerfil));
        assertThat(servicioPerfil.getMailUsuarioAsociado(idPerfil).getUsuarioAsociado().getEmail(), equalTo(mailUsuario));


    }
}
