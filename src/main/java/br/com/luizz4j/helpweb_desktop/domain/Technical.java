package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Technical extends Colaborator{

    public Technical(Long id, String name, String cpf, String email, String password, RoleEnums roles) {
        super(id, name, cpf, email, password, roles);
        setRoles(RoleEnums.TECHNICAL);
    }

    @OneToMany(mappedBy = "technical", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    public Technical() {
        setRoles(RoleEnums.TECHNICAL);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
