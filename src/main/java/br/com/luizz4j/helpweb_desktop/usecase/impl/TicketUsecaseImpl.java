package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import br.com.luizz4j.helpweb_desktop.domain.repository.ITicketRepository;
import br.com.luizz4j.helpweb_desktop.usecase.ITicketUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.TicketResponseDTO;
import br.com.luizz4j.helpweb_desktop.util.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketUsecaseImpl implements ITicketUsecase {

    private final ITicketRepository repository;
    private final IMapper mapper;

    public TicketUsecaseImpl(ITicketRepository repository, IMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // method: created ticket

    @Override
    public void createTicket(TicketRequestDTO dto) {
        Ticket ticket = mapper.fromTicket(dto);
        ticket.setStatusAt(StatusEnums.OPEN);
        repository.save(ticket);
    }

    // method: list of ticket by status

    @Override
    public List<TicketResponseDTO> listTicketOPEN() {
        List<Ticket> listTicketsByStatusOPEN = repository.findByStatus(StatusEnums.OPEN);
        return mapper.fromListTicketResponseDTO(listTicketsByStatusOPEN);
    }
}
