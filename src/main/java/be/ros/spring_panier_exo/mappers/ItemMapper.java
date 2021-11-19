package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.ItemDTO;
import be.ros.spring_panier_exo.models.entities.Item;
import be.ros.spring_panier_exo.models.forms.ItemForm;

@Component
public class ItemMapper implements BaseMapper<ItemDTO, ItemForm, Item> {

    private final CategoryMapper categoryMapper;

    public ItemMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ItemDTO entityToDto(Item entity) {
        return ItemDTO.builder()
                .itemId(entity.getItemId())
                .label(entity.getLabel())
                .category(this.categoryMapper.entityToDto(entity.getCategory()))
                .build();
    }

    @Override
    public Item dtoToEntity(ItemDTO dto) {
        return Item.builder()
                .itemId(dto.getItemId())
                .label(dto.getLabel())
                .category(this.categoryMapper.dtoToEntity(dto.getCategory()))
                .build();
    }

    @Override
    public Item formToEntity(ItemForm form) {
        return Item.builder()
                .label(form.getLabel())
                .category(categoryMapper.formToEntity(form.getCategoryForm()))
                .build();
    }

}
