package com.apimarket.market.domain.port.repository;

import com.apimarket.market.adapters.entities.ProductoEntity;
import com.apimarket.market.domain.model.ProductoModel;

public interface ProductoRepository {

    ProductoModel createProducto(ProductoModel productoModel);

    ProductoModel getProducto(Long ProductoId);
}
