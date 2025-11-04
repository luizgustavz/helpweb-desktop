package br.com.luizz4j.helpweb_desktop.util.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record TicketRequestDTO(

        @NotBlank @Length(min = 6)
        String problem,

        @NotBlank
        String description
) {
}
