package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.controllers;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorAddDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto.FlorUpdateDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlorController {

    @Autowired
    private FlorService service;

    @GetMapping("/flor/getAll")
    public ResponseEntity<?> getAll(){
        return service.getAll();
    }

    @GetMapping("/flor/getOne/{id}")
    public ResponseEntity<?> getFlor(@PathVariable Integer id){
        return service.getFlor(id);
    }

    @PostMapping("/flor/add")
    public ResponseEntity<?> addFlor(@RequestBody FlorAddDTO flor){
        return service.addFlor(flor);
    }

    @PutMapping("flor/update")
    public ResponseEntity<?> updateFlor(@RequestBody FlorUpdateDTO flor){
        return service.updateFlor(flor);
    }

    @DeleteMapping("flor/delete/{id}")
    public ResponseEntity<?> deleteFlor(@PathVariable Integer id){
        return service.deleteFlor(id);
    }

}
