package be.yapock.ccf.bll;

import be.yapock.ccf.pl.models.Dog.DogCreateForm;

public interface DogService {
    void create(DogCreateForm form);
}
