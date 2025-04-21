package com.tallerwebi.dominio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTareaImpl implements TareaService{

    List<Tarea> tareas = new ArrayList<Tarea>();
    private long proximoId = 1;

    @Override
    public void agregarTarea(Tarea tarea) {
        tarea.setId(proximoId++);
        tareas.add(tarea);
    }

    @Override
    public List obtenerTareas() {
        return tareas;
    }

    @Override
    public void marcarComoCompletada(Long id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                tarea.setEstaHecha(true);
                break;
            }
        }

    }

    @Override
    public Tarea obtenerTareaPorId(Long id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                return tarea;
            }
        }
        return null;
    }
}
