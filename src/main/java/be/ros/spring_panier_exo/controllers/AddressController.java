package be.ros.spring_panier_exo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ros.spring_panier_exo.models.dtos.AddressDTO;
import be.ros.spring_panier_exo.services.impl.AddressServiceImpl;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    
    private final AddressServiceImpl addressServiceImpl;

    public AddressController(AddressServiceImpl addressServiceImpl) {
        this.addressServiceImpl = addressServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll(){
        return ResponseEntity.ok(this.addressServiceImpl.getAll());
    }
}
