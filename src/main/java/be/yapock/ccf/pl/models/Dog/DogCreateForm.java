package be.yapock.ccf.pl.models.Dog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DogCreateForm(
        @NotNull @NotBlank
        String firstName,
        String lastName,
        @NotNull @NotBlank
        LocalDate dateOfBirth,
        @NotNull @NotBlank
        String sex,
        boolean isSterilized,
        long breedId,
        LocalDate dateOfVaccine
) {
}
