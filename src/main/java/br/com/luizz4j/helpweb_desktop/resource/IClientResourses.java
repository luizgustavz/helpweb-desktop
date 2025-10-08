package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/client")
public interface IClientResourses {


    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findByID(@PathVariable Long id);

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ClientRequest obj);
}
