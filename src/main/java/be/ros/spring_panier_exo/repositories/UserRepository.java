package be.ros.spring_panier_exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ros.spring_panier_exo.models.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
