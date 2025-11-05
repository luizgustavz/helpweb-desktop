package br.com.luizz4j.helpweb_desktop.util.dto.request.client;

import jakarta.validation.constraints.Email;

public record LoginClientRequest(
        @Email
        String email,

        String password
) {
}
