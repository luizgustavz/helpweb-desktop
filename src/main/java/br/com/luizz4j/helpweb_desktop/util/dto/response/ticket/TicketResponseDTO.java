package br.com.luizz4j.helpweb_desktop.util.dto.response.ticket;

import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketResponseDTO(
        UUID id,
        String problem,
        String description,
        StatusEnums statusAt,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime updatedAt
) {
}
