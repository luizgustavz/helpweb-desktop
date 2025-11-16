package br.com.luizz4j.helpweb_desktop.service;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.Technical;
import br.com.luizz4j.helpweb_desktop.util.dto.request.LoginUserRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.JwtUserResponseDTO;

public interface IAuthenticationService {

    // register client

    Client createClient(UserRequestDTO clientDTO);

    // register technical

    Technical createTechnical(UserRequestDTO technicalDTO);

    // login user

    JwtUserResponseDTO login(LoginUserRequestDTO loginDTO);


}
