package com.tallerwebi.dominio;

import java.util.List;

public interface TareaService {
    public void agregarTarea(Tarea tarea);
    public List<Tarea> obtenerTareas();
    public void marcarComoCompletada(Long id);
    public Tarea obtenerTareaPorId(Long id);
}
