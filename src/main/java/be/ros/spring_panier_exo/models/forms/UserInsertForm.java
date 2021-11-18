package be.ros.spring_panier_exo.models.forms;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
public class UserInsertForm {
    
    @Length(min = 3, max = 30)
    String username;
    @Length(min = 3, max = 30)
    String password;
    
    private List<String> roles;


}
