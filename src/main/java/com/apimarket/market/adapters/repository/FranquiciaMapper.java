package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.FranquiciaEntity;
import com.apimarket.market.domain.model.FranquiciaModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper {

    FranquiciaModel toModel(FranquiciaEntity franquiciaEntity);

    FranquiciaEntity toEntity(FranquiciaModel franquiciaModel);


}
