package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.config.jwt.TokenConfig;
import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.resource.IAuthResource;
import br.com.luizz4j.helpweb_desktop.usecase.impl.ClientUsecaseImpl;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthResourceImpl implements IAuthResource {

    private final ClientUsecaseImpl usecase;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig token;

    public AuthResourceImpl(
            ClientUsecaseImpl usecase,
            AuthenticationManager authenticationManager,
            TokenConfig token
    ) {
        this.usecase = usecase;
        this.authenticationManager = authenticationManager;
        this.token = token;
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginClientRequest request) {
        UsernamePasswordAuthenticationToken emailAndPassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication auth = authenticationManager.authenticate(emailAndPassword);

        Client client = (Client) auth.getPrincipal();
        String t = token.generatedToken(client);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new LoginResponse(t));
    }

    @Override
    public ResponseEntity<ClientResponse> signup(ClientRequest obj) {
        usecase.save(obj);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                    .build();
    }
}

