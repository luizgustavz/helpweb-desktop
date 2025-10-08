package br.com.luizz4j.helpweb_desktop.util.mapper;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IMapper {

    ClientResponse fromDto(Client obj);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Client fromEntity(ClientRequest request);

}
