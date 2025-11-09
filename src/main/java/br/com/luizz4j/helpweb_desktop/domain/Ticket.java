package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String problem;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnums statusAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime closedAt;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_technical")
    private Technical technical;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_client")
    private Client client;

    public Ticket(){};

    public Ticket(
            UUID id,
            String problem,
            String description,
            StatusEnums statusAt,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime closedAt,
            Technical technical,
            Client client
    ) {
            this.id = id;
            this.problem = problem;
            this.description = description;
            this.statusAt = statusAt;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.closedAt = closedAt;
            this.technical = technical;
            this.client = client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnums getStatusAt() {
        return statusAt;
    }

    public void setStatusAt(StatusEnums statusAt) {
        this.statusAt = statusAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public Technical getTechnical() {
        return technical;
    }

    public void setTechnical(Technical technical) {
        this.technical = technical;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ticket ticket)) return false;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
