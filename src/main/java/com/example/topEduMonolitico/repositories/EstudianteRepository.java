package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteEntity, Long> {
    /*public EstudianteEntity findByEmail(String email);
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.email = :email", nativeQuery = true)
    EstudianteEntity findByEmailNativeQuery(@Param("email") String email);*/

}