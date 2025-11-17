package br.com.luizz4j.helpweb_desktop.util.mapper;

import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperTicket {

    Ticket fromTicket(TicketRequestDTO dto);

    List<TicketResponseDTO> fromListTicketResponseDTO(List<Ticket> obj);

    TicketResponseDTO fromTicketDTO(Ticket obj);
}
