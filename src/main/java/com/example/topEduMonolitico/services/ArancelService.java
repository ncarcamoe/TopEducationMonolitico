package com.example.topEduMonolitico.services;

import com.example.topEduMonolitico.entities.ArancelEntity;
import com.example.topEduMonolitico.repositories.ArancelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ArancelService {
    @Autowired
    ArancelRepository ArancelRepository;
    
    public ArrayList<ArancelEntity> obtenerAranceles(){
        return (ArrayList<ArancelEntity>) ArancelRepository.findAll();
    }

    public ArancelEntity guardarArancel(ArancelEntity arancel){
        return ArancelRepository.save(arancel);
    }

    public ArancelEntity obtenerPorId(Long id){
        Optional<ArancelEntity> arancelOptional = ArancelRepository.findById(id);
        ArancelEntity arancel = new ArancelEntity();
        if (arancelOptional.isPresent()) {
            arancel = arancelOptional.get();
        }
        return arancel;
    }

    public boolean eliminarArancel(Long id) {
        try{
            ArancelRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}