package be.ros.spring_panier_exo.models.forms;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
public class CategoryForm {

    @Length(min = 3, max = 30)
    String label;

}
