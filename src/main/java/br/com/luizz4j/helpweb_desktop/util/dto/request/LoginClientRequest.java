package br.com.luizz4j.helpweb_desktop.util.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginClientRequest(
        @Email @NotBlank(message = "Informe um E-mail valido") String email,
        String password
) {
}
