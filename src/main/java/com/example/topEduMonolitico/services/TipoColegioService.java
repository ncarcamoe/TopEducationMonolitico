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

    public TipoColegioEntity guardarEstudiante(TipoColegioEntity tipoColegio){
        return TipoColegioRepository.save(tipoColegio);
    }

    public Optional<TipoColegioEntity> obtenerPorId(Long id){
        return TipoColegioRepository.findById(id);
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