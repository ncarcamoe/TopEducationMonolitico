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

    public Optional<ColegioEntity> obtenerPorId(Long id){
        return ColegioRepository.findById(id);
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