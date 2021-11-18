package be.ros.spring_panier_exo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ros.spring_panier_exo.models.dtos.UserDTO;
import be.ros.spring_panier_exo.services.impl.UserServiceImpl;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUser() {
        return ResponseEntity.ok(this.userServiceImpl.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getOne(@PathVariable Long id){
        return ResponseEntity.ok(this.userServiceImpl.getOneById(id));
    }
}
