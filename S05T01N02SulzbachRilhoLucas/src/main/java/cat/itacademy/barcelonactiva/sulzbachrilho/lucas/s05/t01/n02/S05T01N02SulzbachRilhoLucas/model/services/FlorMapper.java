package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorAddDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class FlorMapper {

    public FlorResponseDTO entityToDTO (FlorEntity flor)
    {
        return new FlorResponseDTO(flor.getPk_FlorID(), flor.getNomFlor(), flor.getPaisFlor());
    }

    public FlorEntity DTOToEntity (FlorAddDTO florDTO)
    {
        return new FlorEntity(florDTO.getNomFlor(), florDTO.getPaisFlor());
    }
}
