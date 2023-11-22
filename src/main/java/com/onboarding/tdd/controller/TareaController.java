package com.onboarding.tdd.controller;

import com.onboarding.tdd.controller.request.TareaRequest;
import com.onboarding.tdd.model.Tarea;
import com.onboarding.tdd.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaRequest tareaRequest) {
        Tarea nuevaTarea = tareaService.crearTarea(tareaRequest.getDescripcion());
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodasLasTareas() {
        List<Tarea> tareas = tareaService.obtenerTodasLasTareas();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }
}
