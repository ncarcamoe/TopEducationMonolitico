package com.example.topEduMonolitico.services;

import com.example.topEduMonolitico.entities.CuotaEntity;
import com.example.topEduMonolitico.entities.TipoColegioEntity;
import com.example.topEduMonolitico.repositories.CuotaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

@Service
public class CuotaService {
    @Autowired
    CuotaRepository CuotaRepository;
    
    public ArrayList<CuotaEntity> obtenerCuotasPorIdEstudiante(Long idEstudiante){
        return CuotaRepository.findByEstudianteIdEstudiante(idEstudiante);
    }

    public CuotaEntity guardarCuota(CuotaEntity cuota){
        return CuotaRepository.save(cuota);
    }

    public CuotaEntity obtenerPorId(Long id){
        Optional<CuotaEntity> cuotaOptional = CuotaRepository.findById(id);
        CuotaEntity cuota = new CuotaEntity();
        if (cuotaOptional.isPresent()) {
            cuota = cuotaOptional.get();
        }
        return cuota;
    }

    @Transactional
    public boolean eliminarCuota(Long idEstudiante, Short anio) {
        try{
            CuotaRepository.deleteByEstudianteIdEstudianteAndArancelAnio(idEstudiante,anio);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<CuotaEntity> generarCuotas(CuotaEntity cuota, TipoColegioEntity tipoColegio) {
        Integer arancel = cuota.getArancel().getValor();
        Integer descuento = generarDescuento(arancel,tipoColegio.getPorcDescuento());
        descuento = descuento + descuentoPorAnio(arancel,cuota.getEstudiante().getAnioEgreso());
        arancel = arancel - descuento;
        Integer valorCuota = dividirCuotas(arancel,cuota.getNumCuota());
        ArrayList<CuotaEntity> cuotas = new ArrayList<>();
        for (int i = 1; i <= cuota.getNumCuota(); i++) {

            Calendar calendario = Calendar.getInstance();
            calendario.add(Calendar.MONTH, i);
            calendario.set(Calendar.DAY_OF_MONTH, 10);

            CuotaEntity cuotaNew = new CuotaEntity();
            cuotaNew.setNumCuota(i);
            cuotaNew.setValorCuota(valorCuota);
            cuotaNew.setPagado(Boolean.FALSE);
            cuotaNew.setFechaVencimiento(calendario.getTime());
            cuotaNew.setArancel(cuota.getArancel());
            cuotaNew.setEstudiante(cuota.getEstudiante());
            cuotas.add(guardarCuota(cuotaNew));
        }
        return cuotas;
    }

    public Integer generarDescuento(Integer valorArancel, Short descuento){
        return (int) (valorArancel * (0.01 * descuento));
    }
    public Integer dividirCuotas(Integer valorArancel, Integer cantidadCuotas){
        return valorArancel/cantidadCuotas;
    }

    public Integer descuentoPorAnio(Integer valorArancel, Short anio){
        Calendar calendario = Calendar.getInstance();
        Integer anioActual = calendario.get(Calendar.YEAR);

        Integer diferencia = anioActual - anio;
        Integer descuento = 0;
        if (diferencia < 1) {
            descuento = (int) (valorArancel * (0.01 * 15));
        } else if (diferencia >= 1 && diferencia <= 2) {
            descuento = (int) (valorArancel * (0.01 * 8));
        } else if (diferencia >= 3 && diferencia <= 4) {
            descuento = (int) (valorArancel * (0.01 * 4));
        }
        return descuento;
    }
  
}