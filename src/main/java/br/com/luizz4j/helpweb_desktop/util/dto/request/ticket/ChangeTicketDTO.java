package br.com.luizz4j.helpweb_desktop.util.dto.request.ticket;

import br.com.luizz4j.helpweb_desktop.resource.exceptions.message.StandardMessageError;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChangeTicketDTO(

        @NotNull(message = StandardMessageError.INVALID_TICKET_NOTNULL)
        @NotBlank(message = StandardMessageError.INVALID_TICKET_NOTBLANK)
        String problem,

        @NotNull(message = StandardMessageError.INVALID_TICKET_NOTNULL)
        @NotBlank(message = StandardMessageError.INVALID_CPF_NOTBLANK)
        String description
) {
}
