package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.SucursalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalCrudRepository extends CrudRepository<SucursalEntity, Long> {

}
