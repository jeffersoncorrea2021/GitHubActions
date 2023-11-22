package com.onboarding.tdd.service;


import com.onboarding.tdd.model.Tarea;
import com.onboarding.tdd.repository.TareaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TareaServiceTest {

    @InjectMocks
    private TareaService tareaService;

    @Mock
    private TareaRepository tareaRepository;
    @Test
    public void deberiaCrearUnaTarea() {
        // Given
        TareaRepository tareaRepositoryMock = mock(TareaRepository.class);
        TareaService tareaService = new TareaService(tareaRepositoryMock);

        // When
        Tarea tarea = tareaService.crearTarea("Descripción de la tarea");

        // Then
        assertEquals("Descripción de la tarea", tarea.getDescripcion());
    }



    @Test
    public void obtenerTodasLasTareas_DeberiaDevolverListaDeTareas() {
        // Given
        MockitoAnnotations.initMocks(this);

        Tarea tarea1 = new Tarea();
        tarea1.setId(1L);
        tarea1.setDescripcion("Tarea 1");

        Tarea tarea2 = new Tarea();
        tarea2.setId(2L);
        tarea2.setDescripcion("Tarea 2");

        List<Tarea> listaTareas = Arrays.asList(tarea1, tarea2);

        when(tareaRepository.findAll()).thenReturn(listaTareas);

        // When
        List<Tarea> resultado = tareaService.obtenerTodasLasTareas();

        // Then
        assertEquals(2, resultado.size());
        assertEquals(tarea1.getId(), resultado.get(0).getId());
        assertEquals(tarea1.getDescripcion(), resultado.get(0).getDescripcion());
        assertEquals(tarea2.getId(), resultado.get(1).getId());
        assertEquals(tarea2.getDescripcion(), resultado.get(1).getDescripcion());
    }
}