package com.apimarket.market.handler.rest.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SucursalRequest {

    @JsonProperty("direccion")
    private String Direccion;

    @JsonProperty("franquicia_id")
    private String FranquiciaId;

    public SucursalRequest(String direccion) {
        Direccion = direccion;
    }
}
