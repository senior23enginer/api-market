package com.apimarket.market.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoModel {

    private Long ProductoId;
    private String Nombre;
    private String Categoria;
    private int Stock;
    private Long SucursalId;
    private Date CreateAt;
    private String Status;


    public ProductoModel(Long productoId, int stock) {
        ProductoId = productoId;
        Stock = stock;
    }

    public ProductoModel(Long productoId, Long sucursalId) {
        ProductoId = productoId;
        SucursalId = sucursalId;
    }

    public ProductoModel(String nombre) {
        Nombre = nombre;
    }

    public ProductoModel(String nombre, String categoria) {
        Nombre = nombre;
        Categoria = categoria;
    }

    public ProductoModel(Long productoId, String nombre) {
        ProductoId = productoId;
        Nombre = nombre;
    }
}
