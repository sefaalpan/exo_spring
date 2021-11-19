package be.ros.spring_panier_exo.models.forms;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
public class UserForm {
    
    @Length(min = 3, max = 30)
    String username;
    
    @Length(min = 3, max = 30)
    String password;
    
    @Length(min = 3, max = 30)
    String email;

    
    private List<String> roles;


}
