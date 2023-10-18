package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.ArancelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArancelRepository extends CrudRepository<ArancelEntity, Long> {

}