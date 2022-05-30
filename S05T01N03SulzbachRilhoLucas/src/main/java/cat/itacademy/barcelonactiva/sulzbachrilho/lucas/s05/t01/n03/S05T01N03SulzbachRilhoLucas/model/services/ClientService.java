package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.model.services;

import cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.model.dto.ClientFlorAddDTO;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    public ResponseEntity<?> getAll (){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:9001/flor/getAll")
                .build();
        ResponseEntity <?> response;
        try {
            response = restTemplate.getForEntity("/", String.class);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<String>(e.getStatusCode());

        }
        return response;
    }

    public ResponseEntity<?> getOne (Integer id){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:9001/flor/getOne")
                .build();
        ResponseEntity <?> response;
        try {
            response = restTemplate.getForEntity("/{id}", String.class, id);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<String>(e.getStatusCode());

        }
        return response;
    }

    public ResponseEntity<?> deleteFlor (Integer id){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:9001/flor/delete")
                .build();
        ResponseEntity <?> response;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(headers);
        try {
            response = restTemplate.exchange("/{id}", HttpMethod.DELETE, request, String.class, id);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<String>(e.getStatusCode());

        }
        return response;
    }

    public ResponseEntity<?> addFlor (ClientFlorAddDTO addDTO){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:9001/flor/add")
                .build();
        ResponseEntity <?> response;
        HttpEntity<ClientFlorAddDTO> request = new HttpEntity<>(addDTO);
        try {
            response = restTemplate.exchange("/", HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<String>(e.getStatusCode());

        }
        return response;
    }
}
