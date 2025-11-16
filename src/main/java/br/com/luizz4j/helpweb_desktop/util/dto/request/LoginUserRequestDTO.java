package br.com.luizz4j.helpweb_desktop.util.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record LoginUserRequestDTO(

        @Email
        @NotBlank
        String email,

        @Length(min = 8)
        @NotBlank
        String password
) {
}
