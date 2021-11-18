package be.ros.spring_panier_exo.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long addressId;

    @Column(nullable = false)
    String street;
    
    @Column(nullable = false)
    String city;
    
    @Column(nullable = false)
    String zipCode;
    
    @Column(nullable = false)
    String country;

    @Column(nullable = false)
    @OneToMany(targetEntity = User.class , mappedBy = "address", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    List<User> users;


}