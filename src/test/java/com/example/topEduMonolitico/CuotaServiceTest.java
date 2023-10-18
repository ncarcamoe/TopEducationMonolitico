package com.example.topEduMonolitico;

import com.example.topEduMonolitico.entities.EstudianteEntity;
import com.example.topEduMonolitico.services.CuotaService;
import com.example.topEduMonolitico.services.EstudianteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CuotaServiceTest {
    CuotaService cuotaService = new CuotaService();

    @Test
    void generarDescuento() {
        Integer arancel = 1000000;
        Short descuento = 15;
        Integer arancelNuevo = cuotaService.generarDescuento(arancel,descuento);
        assertEquals(150000, arancelNuevo, 0.0);
    }

    @Test
    void dividirCuotas() {
        Integer arancel = 1000000;
        Integer numCuotas = 10;
        Integer valorCuota = cuotaService.dividirCuotas(arancel,numCuotas);
        assertEquals(100000, valorCuota, 0.0);
    }


    @Test
    void descuentoPorAnio() {
        Integer arancel = 1000000;
        Short anio = 2009;
        Integer valorCuota = cuotaService.descuentoPorAnio(arancel,anio);
        assertEquals(0, valorCuota, 0.0);
    }
}