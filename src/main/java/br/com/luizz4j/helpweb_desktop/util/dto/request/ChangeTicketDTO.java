package br.com.luizz4j.helpweb_desktop.util.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChangeTicketDTO(

        @NotNull @NotBlank
        String problem,

        @NotNull @NotBlank
        String description
) {
}
