package br.com.luizz4j.helpweb_desktop.domain.repository;

import br.com.luizz4j.helpweb_desktop.domain.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ITechnicalRepository extends JpaRepository<Technical, Long> {

    Optional<UserDetails> findTechnicalByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);


}
