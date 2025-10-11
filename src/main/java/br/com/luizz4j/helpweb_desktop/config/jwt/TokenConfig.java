package br.com.luizz4j.helpweb_desktop.config.jwt;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {

    private final String SECRET = "secret";

    public String generatedToken(Client obj){

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT
                .create()
                .withClaim("id", obj.getId())
                .withSubject(obj.getEmail())
                .withExpiresAt(Instant.now().plusMillis(600000))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

}
