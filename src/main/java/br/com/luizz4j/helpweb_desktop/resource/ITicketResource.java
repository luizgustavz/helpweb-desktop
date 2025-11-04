package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.TicketResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/tickets")
public interface ITicketResource {

    @PostMapping
    ResponseEntity<Void> create(@RequestBody @Valid TicketRequestDTO dto);

    @GetMapping
    ResponseEntity<List<TicketResponseDTO>> listTicketsOPEN();

    @GetMapping("/{id}")
    ResponseEntity<TicketResponseDTO> findById(@PathVariable UUID id);
}
