package be.yapock.ccf.pl.models.Dog;

import be.yapock.ccf.dal.models.Breed;
import be.yapock.ccf.dal.models.Dog;
import be.yapock.ccf.dal.models.enums.RaceGroup;

public record DogShortDTO(
        long id,
        String firstname,
        long breedId
) {
    public static DogShortDTO fromEntity(Dog dog){
        if (dog!=null) return new DogShortDTO(dog.getId(), dog.getFirstName(), dog.getBreed().getId());
        else return null;
    }
}
