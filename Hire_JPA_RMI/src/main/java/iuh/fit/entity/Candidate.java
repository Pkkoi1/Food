package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candidate")

public class Candidate implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @Column(name = "candidate_id", nullable = false)
    private String id;

    private String fullName;
    private  int yearOfBirth;
    private String gender;
    private String email;
    private String phone;
    private String description;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    public Candidate(String id, String fullName, int yearOfBirth, String gender, String email, String phone, String description, Position position) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.position = position;
    }

    public Candidate() {
    }


    @Override
    public String toString() {
        return "Candidate{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", position=" + position +
                '}';
    }
}