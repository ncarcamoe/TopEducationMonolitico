package com.example.topEduMonolitico.services;

import com.example.topEduMonolitico.entities.EstudianteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.topEduMonolitico.repositories.EstudianteRepository;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository EstudianteRepository;
    
    public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) EstudianteRepository.findAll();
    }

    public EstudianteEntity guardarEstudiante(EstudianteEntity estudiante){
        return EstudianteRepository.save(estudiante);
    }

    public EstudianteEntity obtenerPorId(Long id){
        Optional<EstudianteEntity> estudianteOptional = EstudianteRepository.findById(id);
        EstudianteEntity estudiante = new EstudianteEntity();
        if (estudianteOptional.isPresent()) {
            estudiante = estudianteOptional.get();
        }
        return estudiante;
    }

    public boolean eliminarEstudiante(Long id) {
        try{
            EstudianteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
  
}