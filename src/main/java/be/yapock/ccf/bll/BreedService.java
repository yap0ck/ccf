package be.yapock.ccf.bll;

import be.yapock.ccf.dal.models.Breed;
import be.yapock.ccf.pl.models.Breed.BreedCreateForm;

import java.util.List;

public interface BreedService {
    void create(BreedCreateForm form);
    Breed getBreedById(Long id);
    List<Breed> getAllBreeds();
    void delete(Long id);
}
