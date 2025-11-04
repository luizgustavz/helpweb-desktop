package br.com.luizz4j.helpweb_desktop.usecase;

import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;

public interface ITicketUsecase {

    void createTicket(TicketRequestDTO dto);

}
