package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/client")
public interface IClientResourses {

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findByID(@PathVariable Long id);

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll();
}
