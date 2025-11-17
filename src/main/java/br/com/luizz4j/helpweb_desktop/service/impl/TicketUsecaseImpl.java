package br.com.luizz4j.helpweb_desktop.service.impl;

import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import br.com.luizz4j.helpweb_desktop.domain.repository.ITicketRepository;
import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketInOpenStatusException;
import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketNotFoundException;
import br.com.luizz4j.helpweb_desktop.service.ITicketUsecase;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.ChangeTicketDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;
import br.com.luizz4j.helpweb_desktop.util.mapper.MapperTicket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TicketUsecaseImpl implements ITicketUsecase {

    private final ITicketRepository repository;
    private final MapperTicket mapper;

    public TicketUsecaseImpl(
            ITicketRepository repository,
            MapperTicket mapper
    ) {
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

        Ticket currentTicket = repository.findById(id).orElseThrow(TicketNotFoundException::new);

        return mapper.fromTicketDTO(currentTicket);
    }

    // method : change ticket

    @Override
    public void changeTicket(UUID id, ChangeTicketDTO dto) {

        Ticket ticketUpdate = repository.findById(id).orElseThrow(TicketNotFoundException::new);

        ticketUpdate.setProblem(dto.problem());
        ticketUpdate.setDescription(dto.description());

        repository.save(ticketUpdate);
    }

    // method: closed ticket

    @Override
    public void closedTicket(UUID id) {

        Ticket ticket = repository.findById(id).orElseThrow(TicketNotFoundException::new);

        if (!ticket.getStatusAt().equals(StatusEnums.PROGRESS)){
            throw new TicketInOpenStatusException();
        }

        ticket.setStatusAt(StatusEnums.CLOSED);
        ticket.setClosedAt(LocalDateTime.now());
        repository.save(ticket);
    }
}
