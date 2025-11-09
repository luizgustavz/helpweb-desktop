package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.config.jwt.TokenConfig;
import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.user.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.ClientNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.PasswordDoesNotMatchException;
import br.com.luizz4j.helpweb_desktop.usecase.IClientUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.LoginResponse;
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
    private final IMapper IMapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig token;

    public ClientUsecaseImpl(
            IClientRepository repository,
            IMapper IMapper,
            PasswordEncoder encoder,
            AuthenticationManager authenticationManager,
            TokenConfig token
    ) {
        this.repository = repository;
        this.IMapper = IMapper;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.token = token;
    }

    @Override
    public LoginResponse login(LoginClientRequest request) {
        UsernamePasswordAuthenticationToken userAndPasswordToken = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPasswordToken);
        Client loginClient = (Client) authentication.getPrincipal();
        String loginToken = token.createJWT(loginClient);
        return new LoginResponse(loginToken);
    }

    @Override
    public ClientResponse findClientById(Long id){

        return IMapper.fromClientResponseDTO(repository.findById(id).orElseThrow(ClientNotFoundException::new));
    }

    @Override
    public void register(ClientRequest obj) {
        credentialValidator(obj.email(), obj.cpf());

        Client currentClient = IMapper.fromClient(obj);
        currentClient.setPassword(encoder.encode(currentClient.getPassword()));
        repository.save(currentClient);
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
        return IMapper
                .fromListClientResponseDTO(repository.findAll());
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
