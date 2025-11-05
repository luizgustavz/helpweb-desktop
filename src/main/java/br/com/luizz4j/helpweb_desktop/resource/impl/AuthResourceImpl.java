package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.IAuthResource;
import br.com.luizz4j.helpweb_desktop.usecase.impl.ClientUsecaseImpl;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResourceImpl implements IAuthResource {

    private final ClientUsecaseImpl usecase;

    public AuthResourceImpl(ClientUsecaseImpl usecase) {
        this.usecase = usecase;
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginClientRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.login(new LoginClientRequest(request.email(), request.password())));
    }

    @Override
    public ResponseEntity<ClientResponse> signup(ClientRequest obj) {
        usecase.register(obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                    .build();
    }
}

