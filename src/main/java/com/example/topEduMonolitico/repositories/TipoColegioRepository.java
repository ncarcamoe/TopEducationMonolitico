package com.example.topEduMonolitico.repositories;

import com.example.topEduMonolitico.entities.TipoColegioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoColegioRepository extends CrudRepository<TipoColegioEntity, Long> {

}