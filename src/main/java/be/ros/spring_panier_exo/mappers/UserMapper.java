package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.UserDTO;
import be.ros.spring_panier_exo.models.entities.User;
import be.ros.spring_panier_exo.models.forms.UserInsertForm;


@Component
public class UserMapper implements BaseMapper<UserDTO, UserInsertForm, User> {

    @Override
    public User dtoToEntity(UserDTO dto) {
        if (dto != null) {
            return User.builder().userId(dto.getUserId()).username(dto.getUsername()).email(dto.getEmail())
                    .roles(dto.getRoles()).accountNonExpired(dto.isAccountNonExpired())
                    .accountNonLocked(dto.isAccountNonLocked()).credentialsNonExpired(dto.isCredentialsNonExpired())
                    .enabled(dto.isEnabled()).build();
        }
        return null;
    }

    @Override
    public UserDTO entityToDto(User entity) {
        if (entity != null) {
            return UserDTO.builder().userId(entity.getUserId()).username(entity.getUsername()).email(entity.getEmail())
                    .roles(entity.getRoles()).accountNonExpired(entity.isAccountNonExpired())
                    .accountNonLocked(entity.isAccountNonLocked())
                    .credentialsNonExpired(entity.isCredentialsNonExpired()).enabled(entity.isEnabled()).build();
        }
        return null;

    }

    @Override
    public User formToEntity(UserInsertForm form) {
        if(form != null) {
            return User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .roles(form.getRoles())
                .build();
        }
        return null;
    }

}