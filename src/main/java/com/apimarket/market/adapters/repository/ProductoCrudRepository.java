package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCrudRepository extends CrudRepository<ProductoEntity, Long> {

}
