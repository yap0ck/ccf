package be.yapock.ccf.pl.models.Address;

import be.yapock.ccf.dal.models.Address;

public record AddressDTO(
        String street,
        int number,
        String box,
        int zipCode,
        String city,
        String country) {
    public static AddressDTO fromEntity(Address address){
        if (address != null) return new AddressDTO(address.getStreet(), address.getNumber(), address.getBox(), address.getZipCode(), address.getCity(), address.getCountry());
        else return null;
    }
}
