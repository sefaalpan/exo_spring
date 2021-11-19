package be.ros.spring_panier_exo.models.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDTO {

    Long categoryId;

    String label;


    
}
