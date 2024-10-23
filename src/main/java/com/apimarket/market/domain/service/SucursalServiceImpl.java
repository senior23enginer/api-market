package com.apimarket.market.domain.service;

import com.apimarket.market.domain.model.FranquiciaModel;
import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.domain.port.repository.FranquiciaRepository;
import com.apimarket.market.domain.port.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements  SucursalService{

    Logger logger = LoggerFactory.getLogger(SucursalServiceImpl.class);
    private final SucursalRepository sucursalRepository;

    /**
     * @param sucursalModel
     * @return
     */
    @Override
    public SucursalModel createSucursal(SucursalModel sucursalModel) {
        sucursalModel.setStatus("Activo");
        sucursalModel.setCreateAt(new Date());
        return sucursalRepository.createSucursal(sucursalModel);
    }

    /**
     * @param sucursalModel
     * @return
     */
    @Override
    public SucursalModel updateSucursal(SucursalModel sucursalModel) {

        SucursalModel model = sucursalRepository.getSucursal(sucursalModel.getSucursalId());
        if( model != null ){
            model.setDireccion( sucursalModel.getDireccion() );
            sucursalRepository.createSucursal( model );
        }
        return model;
    }

    /**
     * @param sucursalModel
     * @return
     */
    @Override
    public SucursalModel assign(SucursalModel sucursalModel) {
        SucursalModel model = sucursalRepository.getSucursal(sucursalModel.getSucursalId());
        if( model != null ){
            model.setFranquiciaId( sucursalModel.getFranquiciaId() );
            sucursalRepository.createSucursal( model );
        }
        return model;
    }
}
