package br.com.luizz4j.helpweb_desktop.resource;

import br.com.luizz4j.helpweb_desktop.util.dto.request.TicketRequestDTO;
import br.com.luizz4j.helpweb_desktop.util.dto.response.TicketResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/tickets")
public interface ITicketResource {

    @PostMapping
    ResponseEntity<Void> create(@RequestBody @Valid TicketRequestDTO dto);

    @GetMapping
    ResponseEntity<List<TicketResponseDTO>> listTicketsOPEN();
}
