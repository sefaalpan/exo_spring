package be.ros.spring_panier_exo.models.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Validated
@Data
public class ItemForm {
    
    @Length(min = 3, max = 30)
    String label;
    @NotNull
    CategoryForm categoryForm;
}
