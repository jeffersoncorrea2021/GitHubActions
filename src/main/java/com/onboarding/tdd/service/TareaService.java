package com.onboarding.tdd.service;


import com.onboarding.tdd.model.Tarea;
import com.onboarding.tdd.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea crearTarea(String descripcion) {
        Tarea nuevaTarea = new Tarea(descripcion);
        tareaRepository.save(nuevaTarea);
        return nuevaTarea;
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaRepository.findAll();
    }
}
