package br.com.luizz4j.helpweb_desktop.config.jwt;

import br.com.luizz4j.helpweb_desktop.domain.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class JwtConfiguration {

    private final String SECRET = "secret";

    private final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    private final long EXPIRED = 86000;

    public String generateJWT(User user){

        return JWT.create()

                .withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(EXPIRED))
                .sign(ALGORITHM);
    }

    public Optional<JwtUserPayload> validateToken(String jwt){

        try {

            DecodedJWT decode = JWT.require(ALGORITHM).build().verify(jwt);

            return Optional.of(JwtUserPayload.builder()

                    .userId(decode.getClaim("userId").asLong())
                    .email(decode.getSubject())
                    .build()
            );
        }
        catch (JWTVerificationException e){

            return Optional.empty();
        }
    }

}
