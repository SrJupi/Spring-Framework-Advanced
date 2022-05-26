package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorDTO;
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
        List<FlorDTO> florDTOList = repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
        if (florDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(florDTOList);
    }

    public ResponseEntity<?> getFlor(Integer id) {
        Optional<FlorDTO> optionalFlorDTO = repository.findById(id).map(mapper::entityToDTO);
        if (optionalFlorDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalFlorDTO.get());
    }

    public ResponseEntity<?> addFlor(FlorDTO florDTO) {
        if (florDTO.getNomFlor() == null){
            return ResponseEntity.badRequest().body("Flor name is empty!");
        }
        if (florDTO.getPaisFlor() == null){
            return ResponseEntity.badRequest().body("Country name is empty!");
        }
        if (repository.existsById(florDTO.getPk_FlorID())){
            return ResponseEntity.badRequest().body(String.format("Id %d already exists!", florDTO.getPk_FlorID()));
        }
        FlorEntity flor = mapper.DTOToEntity(florDTO);
        flor = repository.save(flor);
        return ResponseEntity.created(URI.create(String.format("/fruita/%d", flor.getPk_FlorID()))).build();
    }

    public ResponseEntity<?> updateFlor(FlorDTO florDTO) {
        if (!repository.existsById(florDTO.getPk_FlorID())){
            return ResponseEntity.notFound().build();
        }
        FlorEntity flor = repository.getById(florDTO.getPk_FlorID());
        if (florDTO.getNomFlor() != null){
            flor.setNomFlor(florDTO.getNomFlor());
        }
        if (florDTO.getPaisFlor() != null){
            flor.setPaisFlor(florDTO.getPaisFlor());
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
