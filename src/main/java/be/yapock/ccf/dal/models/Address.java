package be.yapock.ccf.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private int number;
    private String box;
    private int zipCode;
    private String city;
    private String country;
}
