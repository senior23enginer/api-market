package com.apimarket.market.adapters.repository;

import com.apimarket.market.domain.model.SucursalModel;
import com.apimarket.market.domain.port.repository.SucursalRepository;
import com.apimarket.market.adapters.entities.SucursalEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SucursalRepositoryImpl implements SucursalRepository {

    private final SucursalCrudRepository sucursalCrudRepository;
    private final SucursalMapper sucursalMapper;

    /**
     * @param sucursalModel
     * @return
     */
    @Override
    public SucursalModel createSucursal(SucursalModel sucursalModel) {
        SucursalEntity sucursalEntity = sucursalMapper.toEntity(sucursalModel);
        sucursalCrudRepository.save(sucursalEntity);
        return sucursalModel;
    }

    /**
     * @param sucursalId
     * @return
     */
    @Override
    public SucursalModel getSucursal(Long sucursalId) {
        SucursalModel sucursalModel = null;
        SucursalEntity sucursalEntity = sucursalCrudRepository.findById(sucursalId).orElse(null);
        if(sucursalEntity != null){
            sucursalModel =  sucursalMapper.toModel( sucursalEntity );
        }
        return sucursalModel;
    }
}