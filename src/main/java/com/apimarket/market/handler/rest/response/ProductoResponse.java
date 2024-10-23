package com.apimarket.market.handler.rest.response;


import com.apimarket.market.domain.model.ProductoModel;
import com.apimarket.market.domain.model.SucursalModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoResponse {

    @JsonProperty("body")
    private ProductoModel productoModel;

    @JsonProperty("status_code")
    private String statusCode;

    @JsonProperty("message")
    private String messsage;

}
