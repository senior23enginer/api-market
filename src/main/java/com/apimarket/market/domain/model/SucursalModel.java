package com.apimarket.market.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SucursalModel {

    private Long SucursalId;
    private String Direccion;
    private Long FranquiciaId;
    private Date createAt;
    private String Status;

    public SucursalModel(String direccion, Long sucursalId) {
        Direccion = direccion;
        SucursalId = sucursalId;
    }

    public SucursalModel(String direccion) {
        Direccion = direccion;
    }

    public SucursalModel(Long sucursalId, Long franquiciaId) {
        SucursalId = sucursalId;
        FranquiciaId = franquiciaId;
    }
}
