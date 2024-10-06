package co.demo.app.models.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;

    public Employees(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
