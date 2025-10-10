package br.com.luizz4j.helpweb_desktop.config.sec;

import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthConfig implements UserDetailsService {

    private final IClientRepository repository;

    public AuthConfig(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findClientByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
