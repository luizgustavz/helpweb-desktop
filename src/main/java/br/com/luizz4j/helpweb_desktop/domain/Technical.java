package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Technical extends User {

    public Technical(){
        this.setRoles(RoleEnums.TECHNICAL);
    }

    public Technical(
            Long id,
            String name,
            String cpf,
            String email,
            String password,
            LocalDateTime createAt,
            LocalDateTime updateAt,
            RoleEnums roles,
            List<Ticket> tickets
    ) {
            super(id, name, cpf, email, password, createAt, updateAt, roles);
            this.setRoles(RoleEnums.TECHNICAL);
            this.tickets = tickets;
    }

    @OneToMany(mappedBy = "technical", fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
