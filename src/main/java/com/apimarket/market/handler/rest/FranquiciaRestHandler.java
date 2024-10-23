package com.apimarket.market.handler.rest;


import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.service.FranquiciaService;
import com.apimarket.market.handler.rest.request.FranquiciaRequest;
import com.apimarket.market.handler.rest.response.FranquiciaResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

/**
 * order handler rest
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("franquicia")
public class FranquiciaRestHandler {

    Logger logger = LoggerFactory.getLogger(FranquiciaRestHandler.class);

    private final FranquiciaService franquiciaService;

    @PostMapping(value = "/create-franquicia")
    public ResponseEntity<FranquiciaResponse> createFranquicia(@RequestBody final FranquiciaRequest request) throws InvocationTargetException {

        logger.info("franquicia/create-franquicia Log -> Request: {} ",request);
        FranquiciaModel response = franquiciaService.createFranquicia(
                new FranquiciaModel(
                        request.getNombre(),
                        request.getFranquiciante(),
                        request.getFranquiciado(),
                        request.getModeloNegocio())
        );

        if( response != null){
            return ResponseEntity.ok( new FranquiciaResponse( response,"200","return of the franchise model in a satisfactory manner.") );
        }
        return ResponseEntity.ok( new FranquiciaResponse(null,"503","Service Unavailable.") );
    }

    @PatchMapping(value = "/update-name/{id}")
    public ResponseEntity<FranquiciaResponse> updateFranquiciaName(@PathVariable String id, @RequestBody final FranquiciaRequest request) throws InvocationTargetException {

        logger.info("franquicia/update-name/{id} Log -> Request: {} ",request);
        FranquiciaModel response = franquiciaService.updateFranquicia(
                new FranquiciaModel(
                        Long.parseLong(id),
                        request.getNombre())
        );
        if( response != null){
            return ResponseEntity.ok( new FranquiciaResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new FranquiciaResponse(null,"503","Service Unavailable.") );
    }

}
