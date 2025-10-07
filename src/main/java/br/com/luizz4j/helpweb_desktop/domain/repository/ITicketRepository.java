package br.com.luizz4j.helpweb_desktop.domain.repository;

import br.com.luizz4j.helpweb_desktop.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketRepository extends JpaRepository<Ticket, String> {
}
