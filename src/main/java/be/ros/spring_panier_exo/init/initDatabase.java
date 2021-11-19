package be.ros.spring_panier_exo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.entities.Address;
import be.ros.spring_panier_exo.models.entities.Category;
import be.ros.spring_panier_exo.models.entities.Item;
import be.ros.spring_panier_exo.models.entities.User;
import be.ros.spring_panier_exo.repositories.AddressRepository;
import be.ros.spring_panier_exo.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class initDatabase implements InitializingBean {

    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;

    public initDatabase(AddressRepository addressRepository, CategoryRepository categoryRepository) {
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info(">>> !! INITIALIZE DATABASE !! <<<");
        Address address = new Address();
        address.setCity("Chatelet");
        address.setStreet("rue des Cayats, 5");
        address.setCountry("Belgique");
        address.setZipCode("6200");

        List<User> users = Arrays.asList(
                User.builder().username("test").password("test").email("test@email.com").accountNonExpired(true)
                        .accountNonLocked(true).credentialsNonExpired(true).enabled(true).roles(List.of("USER"))
                        .address(address)
                        .build(),

                User.builder().username("louis").password("louis").email("louis@email.com")
                        .accountNonExpired(true).accountNonLocked(true).credentialsNonExpired(true).enabled(true)
                        .roles(List.of("USER"))
                        .address(address)
                        .build(),

                User.builder().username("kim").password("kim").email("kim@email.com").accountNonExpired(true)
                        .accountNonLocked(true).credentialsNonExpired(true).enabled(true).roles(List.of("USER"))
                        .address(address)
                        .build());

            
        
        address.setUsers(users);

        Category category = new Category();
        category.setLabel("sucrerie");

        List<Item> items = Arrays.asList(
            Item.builder()
                .label("Chocolat")
                .category(category)
                .build(),
            Item.builder()
                .label("Bonbon")
                .category(category)
                .build()
        );
        category.setItems(items);
        this.categoryRepository.save(category);
       
        // users.forEach(this.userRepository::save);
        this.addressRepository.save(address);
    }

}
