package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.IClientResourses;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientResourceImpl implements IClientResourses {

    private final IClientUsecase usecase;

    public ClientResourceImpl(IClientUsecase usecase) {
        this.usecase = usecase;
    }

    @Override
    public ResponseEntity<ClientResponse> findByID(Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.findClientById(id));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.findAll());
    }
}
