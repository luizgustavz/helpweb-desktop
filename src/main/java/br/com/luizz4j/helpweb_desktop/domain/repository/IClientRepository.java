package br.com.luizz4j.helpweb_desktop.domain.repository;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {

    Optional<UserDetails> findClientByEmail(String email);
}
