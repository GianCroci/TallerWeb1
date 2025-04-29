package com.tallerwebi.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Perfil {

    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Perfil() {}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

