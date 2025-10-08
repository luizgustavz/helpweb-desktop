package br.com.luizz4j.helpweb_desktop.util.dto.request;

public record ClientRequest(
        String name,
        String cpf,
        String email,
        String password
) {
}
