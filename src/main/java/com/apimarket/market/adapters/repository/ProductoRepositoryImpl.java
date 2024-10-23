package com.apimarket.market.adapters.repository;

import com.apimarket.market.adapters.entities.ProductoEntity;
import com.apimarket.market.domain.model.ProductoModel;
import com.apimarket.market.domain.port.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductoRepositoryImpl implements ProductoRepository {

    private final ProductoCrudRepository productoCrudRepository;
    private final ProductoMapper productoMapper;

    /**
     * @param productoModel
     * @return
     */
    @Override
    public ProductoModel createProducto(ProductoModel productoModel) {
        ProductoEntity productoEntity = productoMapper.toEntity(productoModel);
        productoCrudRepository.save(productoEntity);
        return productoModel;
    }

    @Override
    public ProductoModel getProducto(Long ProductoId) {

        ProductoModel productoModel = null;
        ProductoEntity productoEntity = productoCrudRepository.findById(ProductoId).orElse(null);
        if(productoEntity != null){
            productoModel =  productoMapper.toModel( productoEntity );
        }
        return productoModel;
    }

}