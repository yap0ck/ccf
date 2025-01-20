package be.yapock.ccf.bll.servicesImpl;

import be.yapock.ccf.bll.DogService;
import be.yapock.ccf.dal.models.Dog;
import be.yapock.ccf.dal.repositories.BreedRepository;
import be.yapock.ccf.dal.repositories.DogRepository;
import be.yapock.ccf.pl.models.Dog.DogCreateForm;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;
    private final BreedRepository breedRepository;

    public DogServiceImpl(DogRepository dogRepository, BreedRepository breedRepository) {
        this.dogRepository = dogRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public void create(DogCreateForm form) {
        Dog dog = Dog.builder()
                .firstName(form.firstName())
                .lastName(form.lastName())
                .dateOfBirth(form.dateOfBirth())
                .sex(form.sex())
                .sterilized(form.isSterilized())
                .dateOfVaccine(form.dateOfVaccine())
                .breed(breedRepository.findById(form.breedId()).orElseThrow())
                .build();
        dogRepository.save(dog);
    }
}
