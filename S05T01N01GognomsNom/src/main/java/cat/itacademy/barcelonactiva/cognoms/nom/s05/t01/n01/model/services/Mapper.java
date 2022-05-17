package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public SucursalDTO entityToDTO (Sucursal sucursal)
    {
        return new SucursalDTO(sucursal.getPk_SucursalID(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    public Sucursal DTOToEntity (SucursalDTO sucursalDTO)
    {
        return new Sucursal(sucursalDTO.getPk_SucursalID(), sucursalDTO.getNomSucursal(), sucursalDTO.getPaisSucursal());
    }
}
