package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "certificate")
public class Certificate implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "certificate_id", nullable = false)
    private String id;

    private String name;
    private String organization;
    private LocalDate issueDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Certificate(String id, String name, String organization, LocalDate issueDate, Candidate candidate) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.issueDate = issueDate;
        this.candidate = candidate;
    }

    public Certificate() {
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", issueDate=" + issueDate +
                ", candidate=" + candidate +
                '}';
    }
}