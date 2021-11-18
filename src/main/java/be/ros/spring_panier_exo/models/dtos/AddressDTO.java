package be.ros.spring_panier_exo.models.dtos;

import java.util.List;

import be.ros.spring_panier_exo.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDTO {

    Long addressId;

    String street;

    String city;

    String zipCode;

    String country;
    List<User> users;
}
