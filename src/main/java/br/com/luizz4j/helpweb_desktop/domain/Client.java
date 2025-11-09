package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Client extends Colaborator {

    public Client() {
        setRoles(RoleEnums.COLABORATOR);
    }

    public Client(Long id, String name, String cpf, String email, String password, RoleEnums roles) {
        super(id, name, cpf, email, password, roles);
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
