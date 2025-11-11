package br.com.luizz4j.helpweb_desktop.service.impl;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.Technical;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.domain.repository.ITechnicalRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.user.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.service.IAuthenticationService;
import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.mapper.MapperClient;
import br.com.luizz4j.helpweb_desktop.util.mapper.MapperTechnical;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final IClientRepository clientRepository;

    private final ITechnicalRepository technicalRepository;

    private final PasswordEncoder encoder;

    private final MapperClient mapperClient;

    private final MapperTechnical mapperTechnical;

    public AuthenticationServiceImpl(
            IClientRepository clientRepository,
            ITechnicalRepository technicalRepository,
            PasswordEncoder encoder,
            MapperClient mapperClient,
            MapperTechnical mapperTechnical
    ){
            this.clientRepository = clientRepository;
            this.technicalRepository = technicalRepository;
            this.encoder = encoder;
            this.mapperClient = mapperClient;
            this.mapperTechnical = mapperTechnical;
    }

    @Override
    public Client createClient(UserRequestDTO clientDTO) {

        validateEmailAndCpf(clientDTO.email(), clientDTO.cpf());

        Client newClient = mapperClient.fromClient(clientDTO);
        newClient.setPassword(encoder.encode(newClient.getPassword()));

        return clientRepository.save(newClient);
    }

    @Override
    public Technical createTechnical(UserRequestDTO technicalDTO) {

        validateEmailAndCpf(technicalDTO.email(), technicalDTO.cpf());

        Technical newTechnical = mapperTechnical.fromTechnical(technicalDTO);
        newTechnical.setPassword(encoder.encode(newTechnical.getPassword()));

        return technicalRepository.save(newTechnical);
    }

    private void validateEmailAndCpf(String email, String cpf){

        if (clientRepository.existsByEmail(email) || technicalRepository.existsByEmail(email)){
            throw new EmailAlreadyRegisterException();
        }

        if (clientRepository.existsByCpf(cpf) || technicalRepository.existsByCpf(cpf)){
            throw new CpfAlreadyRegisterException();
        }
    }






}
