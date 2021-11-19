package be.ros.spring_panier_exo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.ros.spring_panier_exo.mappers.UserMapper;
import be.ros.spring_panier_exo.models.dtos.UserDTO;
import be.ros.spring_panier_exo.models.entities.User;
import be.ros.spring_panier_exo.models.forms.UserForm;
import be.ros.spring_panier_exo.repositories.UserRepository;
import be.ros.spring_panier_exo.services.BaseService;


@Service
public class UserServiceImpl implements BaseService<UserDTO, UserForm, Long> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Long delete(Long id) {
        this.userRepository.deleteById(id);
        return id;
    }

    @Override
    public List<UserDTO> getAll() {

        return this.userRepository.findAll()
            .stream()
            .map(this.userMapper::entityToDto)
            .collect(Collectors.toList());

    }

    @Override
    public UserDTO getOneById(Long id) {
        return this.userMapper.entityToDto(this.userRepository.getById(id));
    }

    @Override
    public UserDTO save(UserForm tform) {
        return this.userMapper.entityToDto(
            this.userRepository.save(this.userMapper.formToEntity(tform)));
    }

    @Override
    public UserDTO update(UserForm tform, Long id) {
        
        User user = this.userRepository.findById(id).orElse(null);

        if(user != null) {
            
            user.setUsername(tform.getUsername());
            user.setRoles(tform.getRoles());
            user.setPassword(tform.getPassword());
            this.userRepository.save(user);
        }
       
        return this.userMapper.entityToDto(user);
    }

}
