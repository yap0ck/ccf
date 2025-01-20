package be.yapock.ccf.bll.servicesImpl;

import be.yapock.ccf.bll.DogService;
import be.yapock.ccf.dal.models.Dog;
import be.yapock.ccf.dal.repositories.BreedRepository;
import be.yapock.ccf.dal.repositories.DogRepository;
import be.yapock.ccf.pl.models.Dog.DogCreateForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private final DogRepository dogRepository;
    private final BreedRepository breedRepository;

    public DogServiceImpl(DogRepository dogRepository, BreedRepository breedRepository) {
        this.dogRepository = dogRepository;
        this.breedRepository = breedRepository;
    }

    /**
     * Creates a new Dog entity based on the provided DogCreateForm and saves it to the database.
     *
     * @param form the DogCreateForm containing the necessary data to create a new Dog entity
     */
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

    /**
     * Retrieves a single Dog entity by its ID.
     *
     * @param id the ID of the Dog entity to retrieve
     * @return the Dog entity with the specified ID
     */
    @Override
    public Dog getOne(long id) {
        return dogRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("chien pas trouvé"));
    }

    /**
     * Retrieves all Dog entities from the database.
     *
     * @return a List of Dog entities representing all dogs in the database
     */
    @Override
    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    /**
     * Updates an existing Dog entity with the provided data from the DogCreateForm and saves it to the database.
     *
     * @param id the ID of the Dog entity to update
     * @param form the DogCreateForm containing the updated data
     */
    @Override
    public void update(long id, DogCreateForm form) {
        Dog dog = getOne(id);
        dog.setFirstName(form.firstName());
        dog.setLastName(form.lastName());
        dog.setDateOfBirth(form.dateOfBirth());
        dog.setSex(form.sex());
        dog.setSterilized(form.isSterilized());
        dog.setDateOfVaccine(form.dateOfVaccine());
        dog.setBreed(breedRepository.findById(form.breedId()).orElseThrow(()-> new EntityNotFoundException("race non trouvée")));
        dogRepository.save(dog);
    }

    /**
     * Deletes a dog entity by its ID.
     *
     * @param id the ID of the dog entity to delete
     */
    @Override
    public void delete(long id) {
        dogRepository.deleteById(id);
    }
}
