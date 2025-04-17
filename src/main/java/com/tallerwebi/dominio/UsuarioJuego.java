package com.tallerwebi.dominio;

public class UsuarioJuego {

    private String nombre;
    private String clave;

    public UsuarioJuego(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public Object getNombre() {
        return nombre;
    }
}
