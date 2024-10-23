package com.apimarket.market.adapters.repository;

import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.adapters.entities.SucursalEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalModel toModel(SucursalEntity sucursalEntity);

    SucursalEntity toEntity(SucursalModel sucursalRequest);


}
