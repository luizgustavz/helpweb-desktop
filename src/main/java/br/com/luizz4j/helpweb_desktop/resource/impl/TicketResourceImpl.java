package br.com.luizz4j.helpweb_desktop.resource.impl;

import br.com.luizz4j.helpweb_desktop.resource.ITicketResource;
import br.com.luizz4j.helpweb_desktop.usecase.impl.TicketUsecaseImpl;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.ChangeTicketDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TicketResourceImpl implements ITicketResource {

    private final TicketUsecaseImpl usecase;

    public TicketResourceImpl(TicketUsecaseImpl usecase) {
        this.usecase = usecase;
    }

    @Override
    public ResponseEntity<Void> create(TicketRequestDTO dto) {
        usecase.createTicket(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public ResponseEntity<List<TicketResponseDTO>> listTicketsOPEN() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.listTicketOPEN());
    }

    @Override
    public ResponseEntity<TicketResponseDTO> findById(UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usecase.findById(id));
    }

    @Override
    public ResponseEntity<TicketResponseDTO> changeTicket(UUID id, ChangeTicketDTO dto) {
        usecase.changeTicket(id, dto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public ResponseEntity<TicketResponseDTO> closedTicket(UUID id) {
        usecase.closedTicket(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
