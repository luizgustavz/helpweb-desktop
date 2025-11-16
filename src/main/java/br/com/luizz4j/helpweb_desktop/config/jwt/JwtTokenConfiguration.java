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
public class JwtTokenConfiguration {

    private final String SECRET = "secret";

    public String generateJWT(User user){

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        return JWT
                .create()
                .withClaim("id", user.getId())
                .withSubject(user.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusMillis(600000))
                .sign(algorithm);
    }

    public Optional<JwtUserData> validateToken(String token){

        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        try {
            DecodedJWT decode = JWT.require(algorithm).build().verify(token);
            return Optional.of(
                    JwtUserData
                        .builder()
                        .colaboratorId(decode.getClaim("id").asLong())
                        .email(decode.getSubject())
                        .build()
            );
        }
        catch (JWTVerificationException e){
            return Optional.empty();
        }
    }

}
