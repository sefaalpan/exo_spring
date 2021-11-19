package be.ros.spring_panier_exo.models.dtos;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

    Long userId;
    String username;
    List<String> roles;
    String email;
    String token;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;
    AddressDTO addressDTO;


}
