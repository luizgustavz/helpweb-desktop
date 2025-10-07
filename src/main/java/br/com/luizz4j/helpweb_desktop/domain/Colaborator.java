package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_colaborator")
public abstract class Colaborator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected String cpf;

    protected String email;

    protected String password;

    @CreationTimestamp
    private LocalDateTime createAt;

    @Enumerated
    private RoleEnums roles;

    public Colaborator() {
    }

    public Colaborator(
            Long id,
            String name,
            final String cpf,
            String email,
            String password,
            RoleEnums roles
    ) {
        this.id = id;
        setName(name);
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if (name == null || name.isBlank() || name.trim().length() < 6){
           throw new IllegalArgumentException();
       }
       this.name = name.trim();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public RoleEnums getRoles() {
        return roles;
    }

    public void setRoles(RoleEnums roles) {
        if (roles == null){
           this.roles = RoleEnums.COLABORATOR;
        }
        this.roles = roles;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Colaborator that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
