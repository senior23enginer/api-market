package com.apimarket.market.handler.rest.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranquiciaRequest {

    @JsonProperty("franquicia_id")
    private Long FranquicialId;

    @JsonProperty("nombre")
    private String Nombre;

    @JsonProperty("franquiciante")
    private String Franquiciante;

    @JsonProperty("franquiciado")
    private String Franquiciado;

    @JsonProperty("modelonegocio")
    private String ModeloNegocio;

    public FranquiciaRequest(String nombre, String franquiciante, String franquiciado, String modeloNegocio) {
        Nombre = nombre;
        Franquiciante = franquiciante;
        Franquiciado = franquiciado;
        ModeloNegocio = modeloNegocio;
    }
}
