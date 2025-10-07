package br.com.luizz4j.helpweb_desktop.domain;

import br.com.luizz4j.helpweb_desktop.domain.enums.StatusEnums;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_ticket")
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String problem;

    private String description;

    private StatusEnums statusAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime closedAt;

    @ManyToOne @JoinColumn(name = "id_technical")
    private Technical technical;

    @ManyToOne @JoinColumn(name = "id_client")
    private Client client;

    public Ticket(){

    }

    public Ticket(
            String id,
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
        setProblem(problem);
        setDescription(description);
        this.statusAt = statusAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.technical = technical;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        if (problem == null || problem.trim().isBlank() || problem.length() < 6){
            throw new IllegalArgumentException();
        }
        this.problem = problem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() < 20){
            throw new IllegalArgumentException();
        }
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
