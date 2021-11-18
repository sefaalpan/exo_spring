package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.AddressDTO;
import be.ros.spring_panier_exo.models.entities.Address;
import be.ros.spring_panier_exo.models.forms.AddressForm;

@Component
public class AddressMapper implements BaseMapper<AddressDTO, AddressForm, Address> {

    @Override
    public AddressDTO entityToDto(Address entity) {
        return AddressDTO.builder()
                .addressId(entity.getAddressId())
                .city(entity.getCity())
                .country(entity.getCountry())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .users(entity.getUsers())
                .build();
    }

    @Override
    public Address dtoToEntity(AddressDTO dto) {
        return Address.builder()
                .addressId(dto.getAddressId())
                .city(dto.getCity())
                .country(dto.getCountry())
                .street(dto.getStreet())
                .zipCode(dto.getZipCode())
                .users(dto.getUsers())
                .build();
    }

    @Override
    public Address formToEntity(AddressForm form) {
        return Address.builder()
                .city(form.getCity())
                .country(form.getCountry())
                .street(form.getStreet())
                .zipCode(form.getZipCode())
                .users(form.getUsers())
                .build();
    }
    
}
