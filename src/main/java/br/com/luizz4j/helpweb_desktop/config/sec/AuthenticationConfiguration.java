package br.com.luizz4j.helpweb_desktop.config.sec;

import br.com.luizz4j.helpweb_desktop.domain.repository.IClientRepository;
import br.com.luizz4j.helpweb_desktop.domain.repository.ITechnicalRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationConfiguration implements UserDetailsService {

    private final IClientRepository clientRepository;
    private final ITechnicalRepository technicalRepository;

    public AuthenticationConfiguration(
            IClientRepository clientRepository,
            ITechnicalRepository technicalRepository
    ) {
            this.clientRepository = clientRepository;
            this.technicalRepository = technicalRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return clientRepository
                .findClientByEmail(email)
                .map(client -> (UserDetails) client)
                .or(() -> technicalRepository.findTechnicalByEmail(email).map(technical -> (UserDetails) technical ))
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
