package br.com.luizz4j.helpweb_desktop.usecase.impl;

import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import br.com.luizz4j.helpweb_desktop.domain.repository.ITicketRepository;
import br.com.luizz4j.helpweb_desktop.usecase.ITicketUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.ChangeTicketDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;
import br.com.luizz4j.helpweb_desktop.util.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    // method: find by id

    @Override
    public TicketResponseDTO findById(UUID id) {
        Ticket currentTicket = repository.findById(id).orElse(null);
        return mapper.fromTicketDTO(currentTicket);
    }

    // method : change ticket

    @Override
    public void changeTicket(UUID id, ChangeTicketDTO dto) {
        Ticket ticketUpdate = repository.findById(id).orElse(null);
        if (ticketUpdate == null){
            throw new IllegalArgumentException("Ticket não encontrado");
        }
        ticketUpdate.setProblem(dto.problem());
        ticketUpdate.setDescription(dto.description());
        repository.save(ticketUpdate);


    }
}
