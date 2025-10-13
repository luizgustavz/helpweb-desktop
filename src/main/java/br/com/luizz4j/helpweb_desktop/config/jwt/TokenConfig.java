package br.com.luizz4j.helpweb_desktop.config.jwt;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

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


    public Optional<JwtUserData> isValidToken(String token){

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        try {
            DecodedJWT decode = JWT.require(algorithm).build().verify(token);

            return Optional.of(
                    JwtUserData
                        .builder()
                        .clientId(decode.getClaim("id").asLong())
                        .email(decode.getSubject())
                        .build()
            );
        }
        catch (JWTVerificationException e){
            return Optional.empty();
        }
    }

}
