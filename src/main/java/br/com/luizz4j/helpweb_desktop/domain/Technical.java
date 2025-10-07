package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class Technical extends Colaborator {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "technical")
    private List<Ticket> tickets;

    public Technical() {
        setRoles(RoleEnums.TECHNICAL);
    }

    public Technical(
            Long id,
            String name,
            String cpf,
            String email,
            String password,
            RoleEnums roles
    ) {
        super(id, name, cpf, email, password, roles);
        setRoles(RoleEnums.TECHNICAL);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
