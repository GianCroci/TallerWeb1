package com.tallerwebi.dominio;

public class Contacto {
    private String nombre;
    private String mail;
    private String mensaje;

    public Contacto() {}

    public Contacto(String nombre, String mail, String mensaje) {
        this.nombre = nombre;
        this.mail = mail;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

