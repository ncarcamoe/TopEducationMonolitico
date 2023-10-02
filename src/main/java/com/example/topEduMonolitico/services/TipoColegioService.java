package com.example.topEduMonolitico.services;

import com.example.topEduMonolitico.entities.TipoColegioEntity;
import com.example.topEduMonolitico.repositories.TipoColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TipoColegioService {
    @Autowired
    TipoColegioRepository TipoColegioRepository;
    
    public ArrayList<TipoColegioEntity> obtenerTipoColegios(){
        return (ArrayList<TipoColegioEntity>) TipoColegioRepository.findAll();
    }

    public TipoColegioEntity guardarTipoColegio(TipoColegioEntity tipoColegio){
        return TipoColegioRepository.save(tipoColegio);
    }

    public TipoColegioEntity obtenerPorId(Long id){
        Optional<TipoColegioEntity> tipoColegioOptional = TipoColegioRepository.findById(id);
        TipoColegioEntity tipoColegio = new TipoColegioEntity();
        if (tipoColegioOptional.isPresent()) {
            tipoColegio = tipoColegioOptional.get();
        }
        return tipoColegio;
    }

    public boolean eliminarTipoColegio(Long id) {
        try{
            TipoColegioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}