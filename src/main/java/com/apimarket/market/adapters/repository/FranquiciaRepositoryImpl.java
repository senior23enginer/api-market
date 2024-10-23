package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.FranquiciaEntity;
import com.apimarket.market.adapters.entities.ProductoEntity;
import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.model.ProductoModel;
import com.apimarket.market.domain.port.repository.FranquiciaRepository;
import com.apimarket.market.domain.port.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FranquiciaRepositoryImpl implements FranquiciaRepository {

    private final FranquiciaCrudRepository franquiciaCrudRepository;
    private final FranquiciaMapper franquiciaMapper;

    /**
     * @param franquiciaModel
     * @return
     */
    @Override
    public FranquiciaModel createFranquicia(FranquiciaModel franquiciaModel) {
        FranquiciaEntity franquiciaEntity = franquiciaMapper.toEntity(franquiciaModel);
        franquiciaCrudRepository.save(franquiciaEntity);
        return franquiciaModel;
    }

    /**
     * @param franquiciaId
     * @return
     */
    @Override
    public FranquiciaModel getFranquicia(Long franquiciaId) {
        FranquiciaModel franquiciaModel = null;
        FranquiciaEntity franquiciaEntity = franquiciaCrudRepository.findById(franquiciaId).orElse(null);
        if(franquiciaEntity != null){
            franquiciaModel =  franquiciaMapper.toModel( franquiciaEntity );
        }
        return franquiciaModel;
    }
}