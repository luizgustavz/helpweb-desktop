package br.com.luizz4j.helpweb_desktop.util.dto.response;

import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketResponseDTO(
        UUID id,
        String problem,
        String description,
        StatusEnums statusAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
