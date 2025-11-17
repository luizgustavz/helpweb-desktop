package br.com.luizz4j.helpweb_desktop.service.impl;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.user.ClientNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.PasswordDoesNotMatchException;
import br.com.luizz4j.helpweb_desktop.service.IClientService;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.mapper.MapperClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository repository;

    private final MapperClient mapper;

    private final PasswordEncoder encoder;

    public ClientServiceImpl(
            IClientRepository repository,
            MapperClient mapper,
            PasswordEncoder encoder
    ) {
            this.repository = repository;
            this.mapper = mapper;
            this.encoder = encoder;
    }


    @Override
    public ClientResponse findClientById(Long id){

        return mapper.fromClientResponseDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new));
    }

    @Override
    public List<ClientResponse> findAll() {

        return mapper.fromListClientResponseDTO(repository.findAll());
    }

    @Override
    public void changePasswordDefault(Long id, ChangePasswordDefaultRequest changePasswordDefaultRequest) {

        Client client = repository.findById(id).orElseThrow(ClientNotFoundException::new);

        if (!encoder.matches(changePasswordDefaultRequest.password(), client.getPassword())){
            throw new PasswordDoesNotMatchException();
        }

        client.setPassword(encoder.encode(changePasswordDefaultRequest.newPassword()));
        repository.save(client);
    }
}
