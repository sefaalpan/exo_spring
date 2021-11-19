package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.AddressDTO;
import be.ros.spring_panier_exo.models.entities.Address;
import be.ros.spring_panier_exo.models.forms.AddressForm;

@Component
public class AddressMapper implements BaseMapper<AddressDTO, AddressForm, Address> {

    // private final UserMapper userMapper;

    // public AddressMapper(UserMapper userMapper) {
    //     this.userMapper = userMapper;
    // }

    @Override
    public AddressDTO entityToDto(Address entity) {

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(entity.getAddressId());
        addressDTO.setCity(entity.getCity());
        addressDTO.setCountry(entity.getCountry());
        addressDTO.setStreet(entity.getStreet());
        addressDTO.setZipCode(entity.getZipCode());
        // entity.getUsers().forEach(this.userMapper::entityToDto);

        return addressDTO;


        // return AddressDTO.builder()
        //         .addressId(entity.getAddressId())
        //         .city(entity.getCity())
        //         .country(entity.getCountry())
        //         .street(entity.getStreet())
        //         .zipCode(entity.getZipCode())
        //         .users(entity.getUsers())
        //         .build();
    }

    @Override
    public Address dtoToEntity(AddressDTO dto) {

        Address address = new Address();
        address.setAddressId(dto.getAddressId());
        address.setCity(dto.getCity());
        address.setCountry(dto.getCountry());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());
        // dto.getUsers().forEach(this.userMapper::dtoToEntity);

        return address;


        // return Address.builder()
        //         .addressId(dto.getAddressId())
        //         .city(dto.getCity())
        //         .country(dto.getCountry())
        //         .street(dto.getStreet())
        //         .zipCode(dto.getZipCode())
        //         .users(dto.getUsers())
        //         .build();
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
