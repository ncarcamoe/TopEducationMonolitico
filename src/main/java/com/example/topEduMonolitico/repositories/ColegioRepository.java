package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.ColegioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColegioRepository extends CrudRepository<ColegioEntity, Long> {
}