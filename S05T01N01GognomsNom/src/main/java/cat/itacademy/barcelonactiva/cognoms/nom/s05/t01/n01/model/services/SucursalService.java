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

    public List<?> addSucursal(SucursalAddDTO sucursalAddDTO) {
        List<SucursalDTO> sucursalDTOList = new ArrayList<>();
        if (sucursalAddDTO.getNomSucursal() == null
                || sucursalAddDTO.getPaisSucursal() == null){
            return sucursalDTOList;
        }
        Sucursal sucursal = mapper.AddToEntity(sucursalAddDTO);
        sucursal = repository.save(sucursal);
        sucursalDTOList.add(mapper.entityToDTO(sucursal));
        return sucursalDTOList;
    }

    public List<?> updateSucursal(SucursalUpdateDTO sucursalUpdateDTO) {
        List<SucursalDTO> sucursalDTOList = new ArrayList<>();
        if (sucursalUpdateDTO.getPk_SucursalID() == null
                || !repository.existsById(sucursalUpdateDTO.getPk_SucursalID())){
            return sucursalDTOList;
        }
        Sucursal sucursal = repository.getById(sucursalUpdateDTO.getPk_SucursalID());
        sucursalDTOList.add(mapper.entityToDTO(sucursal));
        if (!sucursalUpdateDTO.getNomSucursal().equals("")){
            sucursal.setNomSucursal(sucursalUpdateDTO.getNomSucursal());
        }
        if (!sucursalUpdateDTO.getPaisSucursal().equals("")){
            sucursal.setPaisSucursal(sucursalUpdateDTO.getPaisSucursal());
        }
        sucursal = repository.save(sucursal);
        sucursalDTOList.add(mapper.entityToDTO(sucursal));
        return sucursalDTOList;
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
