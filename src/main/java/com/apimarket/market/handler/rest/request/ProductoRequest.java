package com.apimarket.market.handler.rest.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoRequest {

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("categoria")
    private String Categoria;

    @JsonProperty("stock")
    private int stock;

    @JsonProperty("sucursal_id")
    private Long SucursalId;



}
