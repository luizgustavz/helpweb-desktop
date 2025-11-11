package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.IAuthenticationResource;
import br.com.luizz4j.helpweb_desktop.service.impl.AuthenticationServiceImpl;
import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationResourceImpl implements IAuthenticationResource {

    private final AuthenticationServiceImpl service;

    public AuthenticationResourceImpl(AuthenticationServiceImpl service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Void> createClient(UserRequestDTO requestDTO) {
        service.createClient(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> createTechnical(UserRequestDTO requestDTO) {
        service.createTechnical(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

