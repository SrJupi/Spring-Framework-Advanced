package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorDTO;
import org.springframework.stereotype.Component;

@Component
public class FlorMapper {

    public FlorDTO entityToDTO (FlorEntity sucursal)
    {
        return new FlorDTO(sucursal.getPk_FlorID(), sucursal.getNomFlor(), sucursal.getPaisFlor());
    }

    public FlorEntity DTOToEntity (FlorDTO sucursalDTO)
    {
        return new FlorEntity(sucursalDTO.getPk_FlorID(), sucursalDTO.getNomFlor(), sucursalDTO.getPaisFlor());
    }
}
