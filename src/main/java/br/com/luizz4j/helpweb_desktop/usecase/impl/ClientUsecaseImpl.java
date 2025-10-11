package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
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
        Client client = new Client();

        client.setName(obj.name());
        client.setCpf(obj.cpf());
        client.setEmail(obj.email());
        client.setPassword(encoder.encode(obj.password()));
        return repository.save(client);
    }
}
