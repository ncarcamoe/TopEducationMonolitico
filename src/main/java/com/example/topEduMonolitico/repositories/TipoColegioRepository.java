package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.TipoColegioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoColegioRepository extends CrudRepository<TipoColegioEntity, Long> {

    @Query("SELECT estudiante.colegio.tipoColegio FROM EstudianteEntity estudiante WHERE estudiante.idEstudiante = :idEstudiante")
    TipoColegioEntity findByIdEstudiante(@Param("idEstudiante") Long idEstudiante);

}