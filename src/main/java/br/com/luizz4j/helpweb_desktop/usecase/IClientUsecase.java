package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;

public interface IClientUsecase {

    ClientResponse findById(Long id);

    Client save(ClientRequest obj);

}
