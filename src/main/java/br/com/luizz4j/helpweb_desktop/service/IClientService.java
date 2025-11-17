package br.com.luizz4j.helpweb_desktop.service;

import br.com.luizz4j.helpweb_desktop.util.dto.request.client.ChangePasswordDefaultRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;

import java.util.List;

public interface IClientService {

    ClientResponse findClientById(Long id);

    List<ClientResponse> findAll();

    void changePasswordDefault(Long id, ChangePasswordDefaultRequest changePasswordDefaultRequest);

}
