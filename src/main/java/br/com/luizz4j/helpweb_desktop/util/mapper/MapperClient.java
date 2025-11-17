package br.com.luizz4j.helpweb_desktop.util.mapper;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.client.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperClient {

    @Mapping(target = "tickets", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Client fromClient(UserRequestDTO clientDTO);

    ClientResponse fromClientResponseDTO(Client obj);

    List<ClientResponse> fromListClientResponseDTO(List<Client> obj);



}
