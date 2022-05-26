package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorDTO;
import org.springframework.stereotype.Component;

@Component
public class FlorMapper {

    public FlorDTO entityToDTO (FlorEntity flor)
    {
        return new FlorDTO(flor.getPk_FlorID(), flor.getNomFlor(), flor.getPaisFlor());
    }

    public FlorEntity DTOToEntity (FlorDTO florDTO)
    {
        if (florDTO.getPk_FlorID() == null){
            return new FlorEntity(florDTO.getNomFlor(), florDTO.getPaisFlor());
        }
        return new FlorEntity(florDTO.getPk_FlorID(), florDTO.getNomFlor(), florDTO.getPaisFlor());
    }
}
