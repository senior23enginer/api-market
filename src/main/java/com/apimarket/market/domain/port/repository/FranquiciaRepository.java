package com.apimarket.market.domain.port.repository;

import com.apimarket.market.domain.model.FranquiciaModel;

public interface FranquiciaRepository {

    FranquiciaModel createFranquicia(FranquiciaModel franquiciaModel);

    FranquiciaModel getFranquicia(Long  franquiciaId);

}
