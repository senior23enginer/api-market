package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.ProductoEntity;
import com.apimarket.market.domain.model.ProductoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoModel toModel(ProductoEntity productoEntity);

    ProductoEntity toEntity(ProductoModel productoModel);


}
