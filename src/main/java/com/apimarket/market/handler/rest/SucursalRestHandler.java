package com.apimarket.market.handler.rest;


import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.domain.service.FranquiciaService;
import com.apimarket.market.domain.service.SucursalService;
import com.apimarket.market.handler.rest.request.FranquiciaRequest;
import com.apimarket.market.handler.rest.request.SucursalRequest;
import com.apimarket.market.handler.rest.response.FranquiciaResponse;
import com.apimarket.market.handler.rest.response.SucursalResponse;
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
@RequestMapping("sucursal")
public class SucursalRestHandler {

    Logger logger = LoggerFactory.getLogger(SucursalRestHandler.class);

    private final SucursalService sucursalService;

    @PostMapping(value = "/create-sucursal")
    public ResponseEntity<SucursalResponse> createSucursal(@RequestBody final SucursalRequest request) throws InvocationTargetException {

        logger.info("sucursal/create-sucursal Log -> Request: {} ",request);
        SucursalModel response = sucursalService.createSucursal(
                new SucursalModel(
                        request.getDireccion()
                )
        );

        if( response != null){
            return ResponseEntity.ok( new SucursalResponse( response,"200","return of the franchise model in a satisfactory manner.") );
        }
        return ResponseEntity.ok( new SucursalResponse(null,"503","Service Unavailable.") );
    }

    @PatchMapping(value = "/update-name/{id}")
    public ResponseEntity<SucursalResponse> updateSucursalName(@PathVariable String id, @RequestBody final SucursalRequest request) throws InvocationTargetException {

        logger.info("sucursal/update-name/{id} Log -> Request: {} {} ",request,id);
        SucursalModel response = sucursalService.updateSucursal(
                new SucursalModel(
                        request.getDireccion(),
                        Long.parseLong(id)
                )
        );
        if( response != null){
            return ResponseEntity.ok( new SucursalResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new SucursalResponse(null,"503","Service Unavailable.") );
    }

    @GetMapping(value = "/asignar/sucursal/{sucursalid}/franquicia/{franquiciaid}")
    public ResponseEntity<SucursalResponse> asignarSucursalFranquicia(
            @PathVariable String sucursalid,
            @PathVariable String franquiciaid) throws InvocationTargetException {

        logger.info("/asignar/sucursal/{sucursalid}/franquicia/{franquiciaid} Log -> Request: {} {} ",sucursalid,franquiciaid);
        SucursalModel response = sucursalService.assign(
                new SucursalModel(
                        Long.parseLong(sucursalid),
                        Long.parseLong(franquiciaid)
                )
        );
        if( response != null){
            return ResponseEntity.ok( new SucursalResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new SucursalResponse(null,"503","Service Unavailable.") );
    }

}
