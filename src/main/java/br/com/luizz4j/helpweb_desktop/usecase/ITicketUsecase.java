package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.ChangeTicketDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ITicketUsecase {

    void createTicket(TicketRequestDTO dto);

    List<TicketResponseDTO> listTicketOPEN();

    TicketResponseDTO findById(UUID id);

    void changeTicket(UUID id, ChangeTicketDTO dto);

}
