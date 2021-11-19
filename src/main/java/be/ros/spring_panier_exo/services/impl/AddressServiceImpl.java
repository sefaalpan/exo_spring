package be.ros.spring_panier_exo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.ros.spring_panier_exo.mappers.AddressMapper;
import be.ros.spring_panier_exo.models.dtos.AddressDTO;
import be.ros.spring_panier_exo.models.entities.Address;
import be.ros.spring_panier_exo.models.forms.AddressForm;
import be.ros.spring_panier_exo.repositories.AddressRepository;
import be.ros.spring_panier_exo.services.BaseService;

@Service
public class AddressServiceImpl implements BaseService<AddressDTO, AddressForm, Long> {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressDTO> getAll() {
        return this.addressRepository.findAll()
        .stream()
        .map(this.addressMapper::entityToDto)
        .collect(Collectors.toList());

    }

    @Override
    public AddressDTO getOneById(Long id) {
        return this.addressMapper.entityToDto(this.addressRepository.findById(id).orElse(null));
    }

    @Override
    public AddressDTO save(AddressForm tform) {
        return this.addressMapper.entityToDto(this.addressRepository.save(this.addressMapper.formToEntity(tform)));

    }

    @Override
    public AddressDTO update(AddressForm tform, Long id) {
        Address address = this.addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setCity(tform.getCity());
            address.setCountry(tform.getCountry());
            address.setStreet(tform.getStreet());
            address.setZipCode(tform.getZipCode());
            address.setUsers(tform.getUsers());
            this.addressRepository.save(address);
        }
        return this.addressMapper.entityToDto(address);
    }

    @Override
    public Long delete(Long id) {
        this.addressRepository.deleteById(id);
        return id;
    }

}
