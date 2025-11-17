package br.com.luizz4j.helpweb_desktop.config.sec;

import br.com.luizz4j.helpweb_desktop.config.jwt.JwtUserPayload;
import br.com.luizz4j.helpweb_desktop.config.jwt.JwtConfiguration;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class SecurityFilterChainConfiguration extends OncePerRequestFilter {

    private final JwtConfiguration jwt;

    private final static String PREFIX = "Bearer ";

    public SecurityFilterChainConfiguration(
            JwtConfiguration jwt
    ) {
            this.jwt = jwt;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            final String header = request.getHeader("Authorization");

            if (Strings.isNotEmpty(header) && header.startsWith(PREFIX)){

                String token = header.substring("Bearer ".length());
                Optional<JwtUserPayload> jwtPayload = jwt.validateToken(token);

                if (jwtPayload.isPresent()){

                    JwtUserPayload jwtUserPayload = jwtPayload.get();

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtUserPayload, null, null);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }

                    filterChain.doFilter(request, response);
            }
            else {
                filterChain.doFilter(request, response);
            }
    }
}
