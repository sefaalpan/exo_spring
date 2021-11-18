package be.ros.spring_panier_exo.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
// public class User implements UserDetails {
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    @ElementCollection(fetch = FetchType.EAGER)
    List<String> roles;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    boolean accountNonExpired;
    @Column(nullable = false)
    boolean accountNonLocked;
    @Column(nullable = false)
    boolean credentialsNonExpired;
    @Column(nullable = false)
    boolean enabled;
    
    @ManyToOne
    @JoinColumn(name="addressId")
    Address address;

    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return roles.stream().
    //         map(SimpleGrantedAuthority::new)
    //         .collect(Collectors.toList());
    // }

}
