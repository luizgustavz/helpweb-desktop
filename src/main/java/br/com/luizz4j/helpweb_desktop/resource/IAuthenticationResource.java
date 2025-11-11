package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public interface IAuthenticationResource {

    @PostMapping("/client")
    ResponseEntity<Void> createClient(@Valid @RequestBody UserRequestDTO requestDTO);

    @PostMapping("/technical")
    ResponseEntity<Void> createTechnical(@Valid @RequestBody UserRequestDTO requestDTO);
}
