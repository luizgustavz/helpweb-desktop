package br.com.luizz4j.helpweb_desktop.util.dto.request.client;

public record ChangePasswordDefaultRequest(
        String password,
        String newPassword
) {
}
