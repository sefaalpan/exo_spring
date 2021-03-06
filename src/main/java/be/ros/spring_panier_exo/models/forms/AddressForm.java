package be.ros.spring_panier_exo.models.forms;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import be.ros.spring_panier_exo.models.entities.User;
import lombok.Data;

@Data
@Validated
public class AddressForm {

    @Length(min = 3, max = 30)
    String street;

    @Length(min = 3, max = 30)
    String city;

    @Length(min = 3, max = 30)
    String zipCode;

    @Length(min = 3, max = 30)
    String country;

    List<User> users;

}
