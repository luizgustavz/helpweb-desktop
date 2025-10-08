package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.mapper.IMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientClientUsecaseImpl implements IClientUsecase {

    private final IClientRepository repository;
    private final IMapper mapper;

    public ClientClientUsecaseImpl(IClientRepository repository, IMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponse findById(Long id) {
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Identificador Não encontrado");
        }
        return mapper.fromDto(
                repository.findById(id).get()
        );
    }

    @Override
    public Client save(ClientRequest obj) {
        return repository.save(
                mapper.fromEntity(obj));
    }
}
