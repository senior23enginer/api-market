package com.apimarket.market.domain.service;


import com.apimarket.market.domain.model.ProductoModel;


public interface ProductoService {

    ProductoModel createProducto(ProductoModel productoModel );

    ProductoModel updateProducto( ProductoModel productoModel );

    ProductoModel Stock( ProductoModel productoModel );

    ProductoModel assign( ProductoModel productoModel );

}
