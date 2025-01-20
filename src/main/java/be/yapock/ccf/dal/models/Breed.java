package be.yapock.ccf.dal.models;

import be.yapock.ccf.dal.models.enums.DogSize;
import be.yapock.ccf.dal.models.enums.RaceGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Breed {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private RaceGroup raceGroup;
    private DogSize dogSize;
    private String temperament;
}
