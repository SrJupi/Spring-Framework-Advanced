package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class SucursalService {

    @Autowired
    private SucursalRepository repository;
    @Autowired
    private Mapper mapper;

    public ResponseEntity<?> getAll() {
        List<SucursalDTO> sucursalDTOList = repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
        if (sucursalDTOList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sucursalDTOList);
    }

    public ResponseEntity<?> getSucursal(Integer id) {
        Optional <SucursalDTO> optionalSucursalDTO = repository.findById(id).map(mapper::entityToDTO);
        if (optionalSucursalDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalSucursalDTO.get());
    }

    public ResponseEntity<?> addSucursal(SucursalDTO sucursalDTO) {
        if (sucursalDTO.getNomSucursal() == null){
            return ResponseEntity.badRequest().body("Sucursal name is empty!");
        }
        if (sucursalDTO.getPaisSucursal() == null){
            return ResponseEntity.badRequest().body("Country name is empty!");
        }
        if (repository.existsById(sucursalDTO.getPk_SucursalID())){
            return ResponseEntity.badRequest().body(String.format("Id %d already exists!", sucursalDTO.getPk_SucursalID()));
        }
        Sucursal sucursal = mapper.DTOToEntity(sucursalDTO);
        sucursal = repository.save(sucursal);
        return ResponseEntity.created(URI.create(String.format("/fruita/%d", sucursal.getPk_SucursalID()))).build();
    }

    public ResponseEntity<?> updateSucursal(SucursalDTO sucursalDTO) {
        if (!repository.existsById(sucursalDTO.getPk_SucursalID())){
            return ResponseEntity.notFound().build();
        }
        Sucursal sucursal = repository.getById(sucursalDTO.getPk_SucursalID());
        if (sucursalDTO.getNomSucursal() != null){
            sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        }
        if (sucursalDTO.getPaisSucursal() != null){
            sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        }
        repository.save(sucursal);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteSucursal(Integer id) {
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
