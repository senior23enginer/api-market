package com.apimarket.market.domain.port.repository;

import com.apimarket.market.domain.model.SucursalModel;

public interface SucursalRepository {

    SucursalModel createSucursal(SucursalModel sucursalRequest);

    SucursalModel getSucursal(Long sucursalId);
}
