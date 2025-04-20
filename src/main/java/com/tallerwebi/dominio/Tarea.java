package com.tallerwebi.dominio;

public class Tarea {

    private Long id;
    private String nombre;
    private boolean estaHecha;

    public Tarea(Long id, String nombre, boolean estaHecha) {
        this.id = id;
        this.nombre = nombre;
        this.estaHecha = estaHecha;
    }

    public Tarea() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstaHecha() {
        return estaHecha;
    }

    public void setEstaHecha(Boolean estaHecha) {
        this.estaHecha = estaHecha;
    }
}
