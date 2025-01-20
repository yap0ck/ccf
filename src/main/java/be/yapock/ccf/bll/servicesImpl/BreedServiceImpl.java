package be.yapock.ccf.bll.servicesImpl;

import be.yapock.ccf.bll.BreedService;
import be.yapock.ccf.dal.models.Breed;
import be.yapock.ccf.dal.repositories.BreedRepository;
import be.yapock.ccf.pl.models.Breed.BreedCreateForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedServiceImpl implements BreedService {
    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository){
        this.breedRepository = breedRepository;
    }

    @Override
    public void create(BreedCreateForm form) {
        if (form==null) throw new IllegalArgumentException("le formulaire ne peut être vide");
        Breed breed = Breed.builder()
                .name(form.name())
                .raceGroup(form.raceGroup())
                .dogSize(form.dogSize())
                .temperament(form.temperament())
                .build();
        breedRepository.save(breed);
    }

    /**
     * Retrieves a breed by its ID.
     *
     * @param id The ID of the breed to retrieve.
     * @return The breed corresponding to the given ID.
     */
    @Override
    public Breed getBreedById(Long id) {
        return breedRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("la race n'a pas été trouvée"));
    }

    /**
     * Retrieves all breeds available in the system.
     *
     * @return List of Breed objects representing all breeds in the system.
     */
    @Override
    public List<Breed> getAllBreeds() {
        return breedRepository.findAll();
    }

    /**
     * Deletes a breed from the system by its ID.
     *
     * @param id The ID of the breed to delete.
     */
    @Override
    public void delete(Long id) {
        breedRepository.deleteById(id);
    }


}
