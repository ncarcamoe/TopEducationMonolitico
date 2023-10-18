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
        if(validarRut(estudiante.getRut())){
            return EstudianteRepository.save(estudiante);
        } else {
            throw new RuntimeException("Estudiante no guardado, el RUT ingresado no es valido");
        }
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

    public static boolean validarRut(String rut) {
        // Quitar puntos y guión si los hay
        rut = rut.replace(".", "").replace("-", "").trim();

        // Validar la longitud del RUT
        if (rut.length() < 8 || rut.length() > 9) {
            return false;
        }

        // Separar el RUT del dígito verificador
        String rutNumeros = rut.substring(0, rut.length() - 1);
        char dv = Character.toUpperCase(rut.charAt(rut.length() - 1));

        // Verificar si el dígito verificador es un número o 'K'
        if (!Character.isDigit(dv) && dv != 'K') {
            return false;
        }

        // Calcular el dígito verificador esperado
        int suma = 0;
        int multiplicador = 2;
        for (int i = rutNumeros.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(rutNumeros.charAt(i)) * multiplicador;
            multiplicador = multiplicador == 7 ? 2 : multiplicador + 1;
        }

        int residuo = suma % 11;
        char dvCalculado = (char) (11 - residuo == 11 ? '0' : 11 - residuo == 10 ? 'K' : (char) ('0' + (11 - residuo)));

        // Comparar el dígito verificador calculado con el dado
        return Character.toUpperCase(dv) == dvCalculado;
    }
  
}