package br.com.luizz4j.helpweb_desktop.domain.repository;

import br.com.luizz4j.helpweb_desktop.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
