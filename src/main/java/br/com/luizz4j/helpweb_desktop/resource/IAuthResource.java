package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface IAuthResource {

    @PostMapping("/signup")
    public ResponseEntity<ClientResponse> signup(@Valid @RequestBody ClientRequest request);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginClientRequest request);
}
