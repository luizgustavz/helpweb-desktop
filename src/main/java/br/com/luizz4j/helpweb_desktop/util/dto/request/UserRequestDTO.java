package br.com.luizz4j.helpweb_desktop.util.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public record UserRequestDTO(

        String name,

        @CPF
        @NotBlank
        String cpf,

        @Email
        @NotBlank
        String email,

        @NotBlank
        @Length(min = 8)
        String password
) {
}
