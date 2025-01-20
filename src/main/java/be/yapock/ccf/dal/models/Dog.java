package be.yapock.ccf.dal.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter
public class Dog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private LocalDate dateOfBirth;
    @Setter
    private String sex;
    @Setter
    private boolean sterilized;
    @Setter
    private String picturePath;
    @Setter
    private LocalDate dateOfVaccine;
    @ManyToOne
    @Setter
    @JoinColumn(name = "breed_id")
    private Breed breed;
}
