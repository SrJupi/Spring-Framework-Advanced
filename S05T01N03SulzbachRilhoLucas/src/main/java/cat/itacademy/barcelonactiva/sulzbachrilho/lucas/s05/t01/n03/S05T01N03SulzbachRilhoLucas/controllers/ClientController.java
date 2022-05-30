package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.controllers;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.model.dto.ClientFlorAddDTO;
import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.model.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping ("/flor/clientFlorsAll")
    public ResponseEntity<?> getAll (){
        return service.getAll();
    }

    @GetMapping ("/flor/clientFlorsGetOne/{id}")
    public ResponseEntity<?> getOne (@PathVariable Integer id){
        return service.getOne(id);
    }

    @DeleteMapping("/flor/clientFlorsDelete/{id}")
    public ResponseEntity<?> deleteFlor (@PathVariable Integer id){
        return service.deleteFlor(id);
    }

    @PostMapping("/flor/clientFlorsAdd")
    public ResponseEntity<?> addFlor (@RequestBody ClientFlorAddDTO addDTO){
        return service.addFlor(addDTO);
    }
}
