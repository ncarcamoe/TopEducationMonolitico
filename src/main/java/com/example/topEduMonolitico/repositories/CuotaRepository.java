package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.CuotaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CuotaRepository extends CrudRepository<CuotaEntity, Long> {
    ArrayList<CuotaEntity> findByEstudianteIdEstudiante(Long idEstudiante);

    @Modifying
    @Query("DELETE FROM CuotaEntity c WHERE c.estudiante.idEstudiante = :idEstudiante AND c.arancel.anio = :anio")
    void deleteByEstudianteIdEstudianteAndArancelAnio(@Param("idEstudiante") Long idEstudiante, @Param("anio") Short anio);
}