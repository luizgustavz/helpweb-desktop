package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.TicketResponseDTO;

import java.util.List;

public interface ITicketUsecase {

    void createTicket(TicketRequestDTO dto);

    List<TicketResponseDTO> listTicketOPEN();

}
