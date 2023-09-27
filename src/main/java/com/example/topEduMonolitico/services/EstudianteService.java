package com.example.topEduMonolitico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.topEduMonolitico.entities.EstudianteEntity;
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

    public Optional<EstudianteEntity> obtenerPorId(Long id){
        return EstudianteRepository.findById(id);
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