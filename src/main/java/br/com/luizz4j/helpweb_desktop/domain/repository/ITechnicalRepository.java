package br.com.luizz4j.helpweb_desktop.domain.repository;

import br.com.luizz4j.helpweb_desktop.domain.Technical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnicalRepository extends JpaRepository<Technical, Long> {
}
