package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface IAuthResource {

    @PostMapping("/signup")
    public ResponseEntity<ClientResponse> signup(@RequestBody ClientRequest request);

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginClientRequest request);
}
