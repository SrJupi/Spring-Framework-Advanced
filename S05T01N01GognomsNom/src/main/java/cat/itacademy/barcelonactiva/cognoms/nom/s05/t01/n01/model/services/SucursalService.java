package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalAddDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalUpdateDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SucursalService {

    @Autowired
    private SucursalRepository repository;
    @Autowired
    private Mapper mapper;

    public List<?> getAll() {
        List<SucursalDTO> sucursalDTOList = repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
        return sucursalDTOList;
    }

    public List<?> getSucursal(Integer id) {
        List<SucursalDTO> sucursalDTOList = new ArrayList<>();
        Optional <SucursalDTO> optionalSucursalDTO = repository.findById(id).map(mapper::entityToDTO);
        if (optionalSucursalDTO.isEmpty()){
            return sucursalDTOList;
        }
        sucursalDTOList.add(optionalSucursalDTO.get());
        return sucursalDTOList;
    }

    public ResponseEntity<?> addSucursal(SucursalAddDTO sucursalAddDTO) {
        if (sucursalAddDTO.getNomSucursal() == null){
            return ResponseEntity.badRequest().body("Sucursal name is empty!");
        }
        if (sucursalAddDTO.getPaisSucursal() == null){
            return ResponseEntity.badRequest().body("Country name is empty!");
        }
        Sucursal sucursal = mapper.AddToEntity(sucursalAddDTO);
        sucursal = repository.save(sucursal);
        return ResponseEntity.created(URI.create(String.format("/sucursal/%d", sucursal.getPk_SucursalID()))).build();
    }

    public ResponseEntity<?> updateSucursal(SucursalUpdateDTO sucursalUpdateDTO) {
        if (sucursalUpdateDTO.getPk_SucursalID() == null){
            return ResponseEntity.badRequest().body("Id is needed!");
        }
        if (!repository.existsById(sucursalUpdateDTO.getPk_SucursalID())){
            return ResponseEntity.notFound().build();
        }
        Sucursal sucursal = repository.getById(sucursalUpdateDTO.getPk_SucursalID());
        if (sucursalUpdateDTO.getNomSucursal() != null){
            sucursal.setNomSucursal(sucursalUpdateDTO.getNomSucursal());
        }
        if (sucursalUpdateDTO.getPaisSucursal() != null){
            sucursal.setPaisSucursal(sucursalUpdateDTO.getPaisSucursal());
        }
        repository.save(sucursal);
        return ResponseEntity.ok().build();
    }

    public List<?> deleteSucursal(Integer id) {
        List<SucursalDTO> sucursalDTOList = new ArrayList<>();
        if(!repository.existsById(id)){
            return sucursalDTOList;
        }
        Optional <SucursalDTO> optionalSucursalDTO = repository.findById(id).map(mapper::entityToDTO);
        sucursalDTOList.add(optionalSucursalDTO.get());
        repository.deleteById(id);
        return sucursalDTOList;
    }
}
