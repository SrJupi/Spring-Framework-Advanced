package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorAddDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorResponseDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorUpdateDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class FlorService {

    @Autowired
    private FlorRepository repository;
    @Autowired
    private FlorMapper mapper;

    public ResponseEntity<?> getAll() {
        List<FlorResponseDTO> florDTOList = repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
        if (florDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(florDTOList);
    }

    public ResponseEntity<?> getFlor(Integer id) {
        Optional<FlorResponseDTO> optionalFlorDTO = repository.findById(id).map(mapper::entityToDTO);
        if (optionalFlorDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalFlorDTO.get());
    }

    public ResponseEntity<?> addFlor(FlorAddDTO florAddDTO) {
        if (florAddDTO.getNomFlor() == null){
            return ResponseEntity.badRequest().body("Flor name is empty!");
        }
        if (florAddDTO.getPaisFlor() == null){
            return ResponseEntity.badRequest().body("Country name is empty!");
        }
        FlorEntity flor = mapper.DTOToEntity(florAddDTO);
        flor = repository.save(flor);
        return ResponseEntity.created(URI.create(String.format("/flor/%d", flor.getPk_FlorID()))).build();
    }

    public ResponseEntity<?> updateFlor(FlorUpdateDTO florUpdateDTO) {

        Optional<FlorEntity> florOpt = repository.findById(florUpdateDTO.getPk_FlorID());
        if (florOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        FlorEntity flor = florOpt.get();
        if (florUpdateDTO.getNomFlor() != null){
            flor.setNomFlor(florUpdateDTO.getNomFlor());
        }
        if (florUpdateDTO.getPaisFlor() != null){
            flor.setPaisFlor(florUpdateDTO.getPaisFlor());
        }
        repository.save(flor);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteFlor(Integer id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
