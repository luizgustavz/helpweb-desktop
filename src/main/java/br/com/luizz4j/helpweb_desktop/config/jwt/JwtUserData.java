package br.com.luizz4j.helpweb_desktop.config.jwt;

import lombok.Builder;

@Builder
public record JwtUserData(Long colaboratorId, String email) {
}
