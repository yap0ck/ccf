package be.yapock.ccf.bll.servicesImpl;

import be.yapock.ccf.bll.AddressService;
import be.yapock.ccf.dal.models.Address;
import be.yapock.ccf.dal.repositories.AddressRepository;
import be.yapock.ccf.pl.models.Address.AddressForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    /**
     * Creates a new Address entity from the provided AddressForm and saves it using the AddressRepository.
     *
     * @param form the AddressForm object containing the data for the new Address entity
     */
    @Override
    public void create(AddressForm form) {
        Address address = Address.builder()
                .street(form.street())
                .number(form.number())
                .box(form.box())
                .zipCode(form.zipCode())
                .city(form.city())
                .country(form.country())
                .build();
        addressRepository.save(address);
    }

    /**
     * Retrieves an Address entity by its unique ID.
     *
     * @param id the ID of the Address entity to retrieve
     * @return the Address entity if found, otherwise throws EntityNotFoundException
     */
    @Override
    public Address getOne(long id) {
        return addressRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Adresse pas trouvée"));
    }

    /**
     * Deletes an Address entity by its unique ID.
     *
     * @param id the ID of the Address entity to delete
     */
    @Override
    public void delete(long id) {
        addressRepository.deleteById(id);
    }
}
