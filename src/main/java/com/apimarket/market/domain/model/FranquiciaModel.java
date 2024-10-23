package com.apimarket.market.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FranquiciaModel {

    private Long FranquicialId;

    private String Nombre;
    private String Franquiciante;
    private String Franquiciado;
    private String ModeloNegocio;
    private Date createAt;
    private String Status;

    public FranquiciaModel(Long franquicialId, String nombre, String franquiciante, String franquiciado, String modeloNegocio) {
        FranquicialId = franquicialId;
        Nombre = nombre;
        Franquiciante = franquiciante;
        Franquiciado = franquiciado;
        ModeloNegocio = modeloNegocio;
    }

    public FranquiciaModel(String nombre, String franquiciante, String franquiciado, String modeloNegocio) {
        Nombre = nombre;
        Franquiciante = franquiciante;
        Franquiciado = franquiciado;
        ModeloNegocio = modeloNegocio;
    }

    public FranquiciaModel(Long franquicialId, String nombre) {
        FranquicialId = franquicialId;
        Nombre = nombre;
    }
}
