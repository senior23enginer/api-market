package com.apimarket.market.domain.service;

import com.apimarket.market.domain.model.ProductoModel;
import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.domain.port.repository.ProductoRepository;
import com.apimarket.market.domain.port.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements  ProductoService{

    Logger logger = LoggerFactory.getLogger(ProductoServiceImpl.class);
    private final ProductoRepository productoRepository;


    /**
     * @param productoModel
     * @return
     */
    @Override
    public ProductoModel createProducto(ProductoModel productoModel) {
        productoModel.setStatus("Activo");
        productoModel.setCreateAt(new Date());
        return productoRepository.createProducto(productoModel);
    }

    /**
     * @param productoModel
     * @return
     */
    @Override
    public ProductoModel updateProducto(ProductoModel productoModel) {
        ProductoModel model = productoRepository.getProducto(productoModel.getProductoId());
        if( model != null ){
            model.setNombre( productoModel.getNombre() );
            productoRepository.createProducto( model );
        }
        return model;
    }

    /**
     * @param productoModel
     * @return
     */
    @Override
    public ProductoModel Stock(ProductoModel productoModel) {
        ProductoModel model = productoRepository.getProducto(productoModel.getProductoId());
        if( model != null ){
            model.setStock( productoModel.getStock() );
            productoRepository.createProducto( model );
        }
        return model;
    }

    @Override
    public ProductoModel assign(ProductoModel productoModel) {
        ProductoModel model = productoRepository.getProducto(productoModel.getProductoId());
        if( model != null ){
            model.setSucursalId( productoModel.getSucursalId() );
            productoRepository.createProducto( model );
        }
        return model;
    }
}
