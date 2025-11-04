package br.com.luizz4j.helpweb_desktop.util.mapper;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ClientRequest;
import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {

    // mapper client
    ClientResponse fromClientResponseDTO(Client obj);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    Client fromClient(ClientRequest request);

    List<ClientResponse> fromListClientResponseDTO(List<Client> obj);

    // mapper technical

    // mapper ticket

    Ticket fromTicket(TicketRequestDTO dto);

}



