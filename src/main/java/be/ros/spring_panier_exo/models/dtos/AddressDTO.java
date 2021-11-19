package be.ros.spring_panier_exo.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    Long addressId;

    String street;

    String city;

    String zipCode;

    String country;
    // List<UserDTO> users;
}
