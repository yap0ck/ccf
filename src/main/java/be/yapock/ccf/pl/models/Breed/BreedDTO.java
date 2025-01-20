package be.yapock.ccf.pl.models.Breed;

import be.yapock.ccf.dal.models.Breed;
import be.yapock.ccf.dal.models.enums.DogSize;
import be.yapock.ccf.dal.models.enums.RaceGroup;

public record BreedDTO(
        long id,
        String name,
        RaceGroup raceGroup,
        DogSize dogSize,
        String temperament) {
    public static BreedDTO fromEntity(Breed breed){
        if (breed!= null) return new BreedDTO(breed.getId(), breed.getName(), breed.getRaceGroup(),breed.getDogSize(), breed.getTemperament());
        else return null;
    }
}
