package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/client")
public interface IClientResourses {

    @GetMapping("/{id}")
    ResponseEntity<ClientResponse> findByID(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<ClientResponse>> findAll();

    @PutMapping("/{id}/credential")
    ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody ChangePasswordDefaultRequest request);
}
