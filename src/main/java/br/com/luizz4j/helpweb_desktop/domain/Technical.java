package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Technical extends Colaborator implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
