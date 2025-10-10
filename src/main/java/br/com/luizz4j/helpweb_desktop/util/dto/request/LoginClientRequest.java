package br.com.luizz4j.helpweb_desktop.util.dto.request;

public record LoginClientRequest(
        String email,
        String password
) {
}
