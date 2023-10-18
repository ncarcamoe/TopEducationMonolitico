package com.example.topEduMonolitico;

import com.example.topEduMonolitico.services.EstudianteService;
import com.example.topEduMonolitico.entities.EstudianteEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EstudianteServiceTest {
    EstudianteService estudianteService = new EstudianteService();
    EstudianteEntity estudiante = new EstudianteEntity();

    @Test
    void validarRut() {
        String rut = "17047369-8";
        boolean bandera = estudianteService.validarRut(rut);
        assertEquals(true, bandera);
    }
}