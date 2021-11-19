package be.ros.spring_panier_exo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.ros.spring_panier_exo.mappers.CategoryMapper;
import be.ros.spring_panier_exo.mappers.ItemMapper;
import be.ros.spring_panier_exo.models.dtos.ItemDTO;
import be.ros.spring_panier_exo.models.entities.Item;
import be.ros.spring_panier_exo.models.forms.ItemForm;
import be.ros.spring_panier_exo.repositories.ItemRepository;
import be.ros.spring_panier_exo.services.BaseService;

@Service
public class ItemServiceImpl implements BaseService<ItemDTO, ItemForm, Long> {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final CategoryMapper categoryMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper, CategoryMapper categoryMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<ItemDTO> getAll() {
        return this.itemRepository.findAll().stream().map(this.itemMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getOneById(Long id) {
        return this.itemMapper.entityToDto(this.itemRepository.findById(id).orElse(null));
    }

    @Override
    public ItemDTO save(ItemForm tform) {
        return this.itemMapper.entityToDto(this.itemRepository.save(this.itemMapper.formToEntity(tform)));
    }

    @Override
    public ItemDTO update(ItemForm tform, Long id) {
        Item item = this.itemRepository.findById(id).orElse(null);
        
        if (item != null) {
            item.setLabel(tform.getLabel());
            item.setCategory(this.categoryMapper.formToEntity(tform.getCategoryForm()));
        }

        return this.itemMapper.entityToDto(this.itemRepository.save(item));
    }

    @Override
    public Long delete(Long id) {
        this.itemRepository.deleteById(id);
        return id;
    }

}
