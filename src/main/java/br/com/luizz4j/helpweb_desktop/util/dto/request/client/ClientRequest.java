package br.com.luizz4j.helpweb_desktop.util.dto.request.client;

import br.com.luizz4j.helpweb_desktop.resource.exceptions.message.StandardMessageError;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;

public record ClientRequest(

        String name,

        @CPF(message = StandardMessageError.INVALID_CPF)
        @NotBlank(message = StandardMessageError.INVALID_CPF_NOTBLANK)
        String cpf,

        @Email(message = StandardMessageError.INVALID_EMAIL)
        @NotBlank(message = StandardMessageError.INVALID_EMAIL_NOTBLANK)
        String email,

        @With String password
) {
}
