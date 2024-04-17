package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
public class Experience implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "companyName", nullable = false)
    private String companyName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")

    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    public Experience(String companyName, LocalDate fromDate, LocalDate toDate, String description, Candidate candidate, Position position) {
        this.companyName = companyName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.description = description;
        this.candidate = candidate;
        this.position = position;
    }

    public Experience() {
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                ", candidate=" + candidate +
                ", position=" + position +
                '}';
    }
}