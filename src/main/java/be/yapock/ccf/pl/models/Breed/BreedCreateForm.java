package be.yapock.ccf.pl.models.Breed;

import be.yapock.ccf.dal.models.enums.DogSize;
import be.yapock.ccf.dal.models.enums.RaceGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BreedCreateForm(
        @NotNull @NotBlank
        String name,
        RaceGroup raceGroup,
        DogSize dogSize,
        String temperament
) {
}
