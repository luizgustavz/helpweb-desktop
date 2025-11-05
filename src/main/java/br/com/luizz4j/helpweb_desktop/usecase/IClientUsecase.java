package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.LoginResponse;

import java.util.List;

public interface IClientUsecase {

    ClientResponse findClientById(Long id);

    void register(ClientRequest obj);

    LoginResponse login(LoginClientRequest request);

    List<ClientResponse> findAll();





}
