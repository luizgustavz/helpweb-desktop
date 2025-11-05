package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.ChangeTicketDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.request.ticket.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.ticket.TicketResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/tickets")
public interface ITicketResource {

    @PostMapping
    ResponseEntity<Void> create(@RequestBody @Valid TicketRequestDTO dto);

    @GetMapping
    ResponseEntity<List<TicketResponseDTO>> listTicketsOPEN();

    @GetMapping("/{id}")
    ResponseEntity<TicketResponseDTO> findById(@PathVariable UUID id);

    @PutMapping("/{id}/change")
    ResponseEntity<TicketResponseDTO> changeTicket(@PathVariable UUID id, @RequestBody @Valid ChangeTicketDTO dto);

    @PutMapping("/{id}/closed")
    ResponseEntity<TicketResponseDTO> closedTicket(@PathVariable UUID id);
}
