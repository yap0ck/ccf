package be.yapock.ccf.bll;

import be.yapock.ccf.dal.models.Address;
import be.yapock.ccf.pl.models.Address.AddressForm;

public interface AddressService {
    void create(AddressForm form);
    Address getOne(long id);
    void delete(long id);
}
