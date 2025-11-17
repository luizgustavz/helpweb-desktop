package br.com.luizz4j.helpweb_desktop.config.jwt;

import lombok.Builder;

@Builder
public record JwtUserPayload(

        Long userId,
        String email
) {
}
