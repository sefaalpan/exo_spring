package be.ros.spring_panier_exo.models.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemDTO {

    Long itemId;

    String label;

    CategoryDTO category;

    
}
