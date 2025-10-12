package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.IdNotFoundException;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.mapper.IMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientUsecaseImpl implements IClientUsecase {

    private final IClientRepository repository;
    private final IMapper mapper;
    private final PasswordEncoder encoder;

    public ClientUsecaseImpl(
            IClientRepository repository,
            IMapper mapper,
            PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public ClientResponse findById(Long id){
        return mapper
                .fromDto(repository.findById(id).orElseThrow(IdNotFoundException::new));
    }

    @Override
    public Client save(ClientRequest obj) {
        return repository
                .save(mapper.fromEntity(
                        obj.withPassword(encoder.encode(obj.password()))
                ));
    }
}
