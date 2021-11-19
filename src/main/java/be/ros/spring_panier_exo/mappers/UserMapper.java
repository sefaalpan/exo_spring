package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.UserDTO;
import be.ros.spring_panier_exo.models.entities.User;
import be.ros.spring_panier_exo.models.forms.UserForm;


@Component
public class UserMapper implements BaseMapper<UserDTO, UserForm, User> {

    private final AddressMapper addressMapper;

    public UserMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public User dtoToEntity(UserDTO dto) {
        if (dto != null) {
            return User.builder()
                    .userId(dto.getUserId())
                    .username(dto.getUsername())
                    .email(dto.getEmail())
                    .roles(dto.getRoles())
                    .accountNonExpired(dto.isAccountNonExpired())
                    .accountNonLocked(dto.isAccountNonLocked())
                    .credentialsNonExpired(dto.isCredentialsNonExpired())
                    .enabled(dto.isEnabled())
                    .address(this.addressMapper.dtoToEntity(dto.getAddressDTO()))
                    .build();
        }
        return null;
    }

    @Override
    public UserDTO entityToDto(User entity) {
        if (entity != null) {
            return UserDTO.builder().userId(entity.getUserId()).username(entity.getUsername()).email(entity.getEmail())
                    .roles(entity.getRoles()).accountNonExpired(entity.isAccountNonExpired())
                    .accountNonLocked(entity.isAccountNonLocked())
                    .credentialsNonExpired(entity.isCredentialsNonExpired()).enabled(entity.isEnabled())
                    .addressDTO(this.addressMapper.entityToDto(entity.getAddress()))
                    .build();
        }
        return null;

    }

    @Override
    public User formToEntity(UserForm form) {
        if(form != null) {
            return User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .email(form.getEmail())
                .roles(form.getRoles())
                .build();
        }
        return null;
    }

}