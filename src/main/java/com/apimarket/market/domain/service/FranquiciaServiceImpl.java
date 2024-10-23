package com.apimarket.market.domain.service;

import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.port.repository.FranquiciaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements  FranquiciaService{

    Logger logger = LoggerFactory.getLogger(FranquiciaServiceImpl.class);
    private final FranquiciaRepository franquiciaRepository;

    /**
     * @param franquiciaModel
     * @return
     */
    @Override
    public FranquiciaModel createFranquicia(FranquiciaModel franquiciaModel) {
        franquiciaModel.setStatus("Activo");
        franquiciaModel.setCreateAt(new Date());
        return franquiciaRepository.createFranquicia(franquiciaModel);

    }

    /**
     * @param franquiciaModel 
     * @return
     */
    @Override
    public FranquiciaModel updateFranquicia(FranquiciaModel franquiciaModel) {
        FranquiciaModel model = franquiciaRepository.getFranquicia(franquiciaModel.getFranquicialId());
        if( model != null ){
            model.setFranquiciante( franquiciaModel.getNombre() );
            franquiciaRepository.createFranquicia( model );
        }
        return model;
    }
}
