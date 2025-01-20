package be.yapock.ccf.bll;

import be.yapock.ccf.dal.models.Dog;
import be.yapock.ccf.pl.models.Dog.DogCreateForm;

import java.util.List;

public interface DogService {
    void create(DogCreateForm form);
    Dog getOne(long id);
    List<Dog> getAll();
    void update(long id, DogCreateForm form);
    void delete(long id);
}
