package com.apimarket.market.handler.rest;


import com.apimarket.market.domain.model.ProductoModel;
import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.domain.service.ProductoService;
import com.apimarket.market.domain.service.SucursalService;
import com.apimarket.market.handler.rest.request.ProductoRequest;
import com.apimarket.market.handler.rest.request.SucursalRequest;
import com.apimarket.market.handler.rest.response.ProductoResponse;
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
@RequestMapping("producto")
public class ProductoRestHandler {

    Logger logger = LoggerFactory.getLogger(ProductoRestHandler.class);

    private final ProductoService productoService;

    @PostMapping(value = "/create-producto")
    public ResponseEntity<ProductoResponse> createSucursal(@RequestBody final ProductoRequest request) throws InvocationTargetException {

        logger.info("sucursal/create-sucursal Log -> Request: {} ",request);
        ProductoModel response = productoService.createProducto(
                new ProductoModel(
                        request.getNombre(),
                        request.getCategoria()
                )
        );

        if( response != null){
            return ResponseEntity.ok( new ProductoResponse( response,"200","return of the franchise model in a satisfactory manner.") );
        }
        return ResponseEntity.ok( new ProductoResponse(null,"503","Service Unavailable.") );
    }

    @PatchMapping(value = "/update-name/{id}")
    public ResponseEntity<ProductoResponse> updateProductoName(@PathVariable Long id, @RequestBody final ProductoRequest request) throws InvocationTargetException {

        logger.info("sucursal/update-name/{id} Log -> Request: {} {} ",request,id);
        ProductoModel response = productoService.updateProducto(
                new ProductoModel(
                        id,
                        request.getNombre()
                )
        );
        if( response != null){
            return ResponseEntity.ok( new ProductoResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new ProductoResponse(null,"503","Service Unavailable.") );
    }

    @GetMapping(value = "/mover-stock/{productoid}/stock/{stock}")
    public ResponseEntity<ProductoResponse> moverStockProducto(
            @PathVariable Long productoid,
            @PathVariable int stock) throws InvocationTargetException {

        logger.info("/mover-stock/producto/{productoid}/stock/{stock} Log -> Request: {} {} ",productoid,stock);
        ProductoModel response = productoService.Stock(
                new ProductoModel(
                        productoid,
                        stock
                )
        );
        if( response != null){
            return ResponseEntity.ok( new ProductoResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new ProductoResponse(null,"503","Service Unavailable.") );
    }

    @GetMapping(value = "/asignar/{productoid}/sucursal/{sucursalid}")
    public ResponseEntity<ProductoResponse> asignarProductoSucursal(
            @PathVariable Long productoid,
            @PathVariable Long sucursalid) throws InvocationTargetException {

        logger.info("/mover-stock/producto/{productoid}/1/stock/{stock} Log -> Request: {} {} ",productoid,sucursalid);
        ProductoModel response = productoService.assign(
                new ProductoModel(
                        productoid,
                        sucursalid
                )
        );
        if( response != null){
            return ResponseEntity.ok( new ProductoResponse( response,"200","the name is updated correctly.") );
        }
        return ResponseEntity.ok( new ProductoResponse(null,"503","Service Unavailable.") );
    }

}
