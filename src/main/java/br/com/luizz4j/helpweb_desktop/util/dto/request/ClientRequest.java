package br.com.luizz4j.helpweb_desktop.util.dto.request;

import lombok.With;

public record ClientRequest(
        String name,
        String cpf,
        String email,
        @With String password
) {
}
