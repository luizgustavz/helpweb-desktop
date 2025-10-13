package br.com.luizz4j.helpweb_desktop.config.sec;

import br.com.luizz4j.helpweb_desktop.config.jwt.JwtUserData;
import br.com.luizz4j.helpweb_desktop.config.jwt.TokenConfig;
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
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenConfig token;

    public SecurityFilter(TokenConfig token) {
        this.token = token;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            String authorizedHeader = request.getHeader("Authorization");

            if (Strings.isNotEmpty(authorizedHeader) && authorizedHeader.startsWith("Bearer ")){
                String t = authorizedHeader.substring("Bearer ".length());

                Optional<JwtUserData> optionalJWTuserData = token.isValidToken(t);

                if (optionalJWTuserData.isPresent()){

                    JwtUserData jwtUserData = optionalJWTuserData.get();

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            jwtUserData, null, null
                    );

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                filterChain.doFilter(request, response);
            }
            else {
                filterChain.doFilter(request, response);
            }
    }
}
