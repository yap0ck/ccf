package be.yapock.ccf.pl.models.Address;

public record AddressForm(
        String street,
        int number,
        String box,
        int zipCode,
        String city,
        String country
) {
}
