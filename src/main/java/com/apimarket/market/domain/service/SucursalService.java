package com.apimarket.market.domain.service;


import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.model.SucursalModel;

public interface SucursalService {

    SucursalModel createSucursal(SucursalModel sucursalModel );

    SucursalModel updateSucursal( SucursalModel sucursalModel );

    SucursalModel assign( SucursalModel sucursalModel );

}
