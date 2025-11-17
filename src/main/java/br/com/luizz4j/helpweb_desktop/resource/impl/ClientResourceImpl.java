package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.IClientResourses;
import br.com.luizz4j.helpweb_desktop.service.IClientService;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientResourceImpl implements IClientResourses {

    private final IClientService usecase;

    public ClientResourceImpl(IClientService usecase) {
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

    @Override
    public ResponseEntity<Void> changePassword(Long id, ChangePasswordDefaultRequest request) {
        usecase.changePasswordDefault(id, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
