package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.config.jwt.TokenConfig;
import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.IdNotFoundException;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.LoginResponse;
import br.com.luizz4j.helpweb_desktop.util.mapper.IMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUsecaseImpl implements IClientUsecase {

    private final IClientRepository repository;
    private final IMapper mapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig token;

    public ClientUsecaseImpl(
            IClientRepository repository,
            IMapper mapper,
            PasswordEncoder encoder,
            AuthenticationManager authenticationManager,
            TokenConfig token
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.token = token;
    }

    @Override
    public LoginResponse login(LoginClientRequest request) {
        UsernamePasswordAuthenticationToken userAndPasswordToken = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPasswordToken);
        Client loginClient = (Client) authentication.getPrincipal();
        String loginToken = token.generatedToken(loginClient);
        return new LoginResponse(loginToken);
    }

    @Override
    public ClientResponse findById(Long id){
        return mapper
                .fromDto(repository.findById(id).orElseThrow(IdNotFoundException::new));
    }

    @Override
    public Client save(ClientRequest obj) {
        credentialValidator(obj.email(), obj.cpf());
        return repository
                .save(mapper.fromEntity(
                        obj.withPassword(encoder.encode(obj.password()))
                ));
    }

    private void credentialValidator(String email, String cpf){
       if (repository.existsByEmail(email)){
           throw new EmailAlreadyRegisterException();
       };

       if (repository.existsByCpf(cpf)){
           throw new CpfAlreadyRegisterException();
       }
    }

    @Override
    public List<ClientResponse> findAll() {
        return mapper.fromListDto(repository.findAll());
    }
}
