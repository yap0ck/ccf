package be.yapock.ccf.pl.models.Dog;

import be.yapock.ccf.dal.models.Dog;

import java.time.LocalDate;

public record DogFullDTO(
        long id,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String sex,
        boolean isSterilized,
        LocalDate vaccineDate
) {
    public static DogFullDTO fromEntity(Dog dog){
        if (dog!= null) return new DogFullDTO(dog.getId(), dog.getFirstName(), dog.getLastName(), dog.getDateOfBirth(), dog.getSex(), dog.isSterilized(), dog.getDateOfVaccine());
        else return null;
    }
}
