package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.FranquiciaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaCrudRepository extends CrudRepository<FranquiciaEntity, Long> {


}
