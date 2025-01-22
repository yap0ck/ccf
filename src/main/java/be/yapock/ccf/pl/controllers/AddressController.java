package be.yapock.ccf.pl.controllers;

import be.yapock.ccf.bll.AddressService;
import be.yapock.ccf.pl.models.Address.AddressDTO;
import be.yapock.ccf.pl.models.Address.AddressForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    /**
     * Creates a new address based on the provided AddressForm.
     *
     * @param form the AddressForm object containing the details of the new address to be created
     */
    @PostMapping()
    public void create(@RequestBody AddressForm form){
        addressService.create(form);
    }

    /**
     * Retrieves a specific address by ID.
     *
     * @param id the ID of the address to retrieve
     * @return ResponseEntity containing the AddressDTO for the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getOne(@PathVariable long id){
        return ResponseEntity.ok(AddressDTO.fromEntity(addressService.getOne(id)));
    }

    /**
     * Deletes an address with the specified ID.
     *
     * @param id the ID of the address to delete
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        addressService.delete(id);
    }
}
