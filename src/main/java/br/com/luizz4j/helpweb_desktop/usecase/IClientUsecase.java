package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.client.LoginClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.LoginResponse;

import java.util.List;

public interface IClientUsecase {

    void register(ClientRequest obj);

    LoginResponse login(LoginClientRequest request);

    ClientResponse findClientById(Long id);

    List<ClientResponse> findAll();

    void changePasswordDefault(Long id, ChangePasswordDefaultRequest changePasswordDefaultRequest);





}
