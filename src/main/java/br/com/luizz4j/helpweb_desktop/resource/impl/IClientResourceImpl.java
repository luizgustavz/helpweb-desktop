package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.IClientResourses;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IClientResourceImpl implements IClientResourses {

    private final IClientUsecase usecase;

    public IClientResourceImpl(IClientUsecase usecase) {
        this.usecase = usecase;
    }

    @Override
    public ResponseEntity<ClientResponse> findByID(Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.findById(id));
    }

    @Override
    public ResponseEntity<Void> save(ClientRequest obj) {
        usecase.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
