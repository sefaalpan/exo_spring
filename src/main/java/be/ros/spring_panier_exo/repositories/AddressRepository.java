package be.ros.spring_panier_exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.ros.spring_panier_exo.models.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
    

}
