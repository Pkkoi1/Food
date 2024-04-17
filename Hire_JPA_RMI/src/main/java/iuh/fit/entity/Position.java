package iuh.fit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "position")
@NamedQueries({
       @NamedQuery(name = "Position.findListPosition",
               query = "SELECT p FROM Position p " +
                       "where p.name = :name and p.salary >= :salaryFrom " +
                       "and p.salary <= :salaryTo"),
})
public class Position implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "position_id", nullable = false)
    private String id;
    private String name;
    private String description;
    private Double salary;
    private int number;

    public Position(String id, String name, String description, Double salary, int number) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.number = number;
    }

    public Position() {
    }

    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", number=" + number +
                '}';
    }
}