package com.example.topEduMonolitico.services;

import com.example.topEduMonolitico.entities.ColegioEntity;
import com.example.topEduMonolitico.repositories.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ColegioService {
    @Autowired
    ColegioRepository ColegioRepository;
    
    public ArrayList<ColegioEntity> obtenerColegios(){
        return (ArrayList<ColegioEntity>) ColegioRepository.findAll();
    }

    public ColegioEntity guardarColegio(ColegioEntity colegio){
        return ColegioRepository.save(colegio);
    }

    public ColegioEntity obtenerPorId(Long id){
        Optional<ColegioEntity> colegioOptional = ColegioRepository.findById(id);
        ColegioEntity colegio = new ColegioEntity();
        if (colegioOptional.isPresent()) {
            colegio = colegioOptional.get();
        }
        return colegio;
    }

    public boolean eliminarColegio(Long id) {
        try{
            ColegioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
  
}