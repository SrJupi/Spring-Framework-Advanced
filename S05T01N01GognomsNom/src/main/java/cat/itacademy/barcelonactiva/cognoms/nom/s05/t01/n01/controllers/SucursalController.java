package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SucursalController {

    @Autowired
    private SucursalService service;

    @GetMapping("/sucursal/getAll")
    public ResponseEntity<?> getAll(){
        return service.getAll();
    }

    @GetMapping("/sucursal/getOne/{id}")
    public ResponseEntity<?> getSucursal(@PathVariable Integer id){
        return service.getSucursal(id);
    }

    @PostMapping("/sucursal/add")
    public ResponseEntity<?> addSucursal(@RequestBody SucursalDTO sucursal){
        return service.addSucursal(sucursal);
    }

    @PutMapping("sucursal/update")
    public ResponseEntity<?> updateSucursal(@RequestBody SucursalDTO sucursal){
        return service.updateSucursal(sucursal);
    }

    @DeleteMapping("sucursal/delete/{id}")
    public ResponseEntity<?> deleteSucursal(@PathVariable Integer id){
        return service.deleteSucursal(id);
    }
}
