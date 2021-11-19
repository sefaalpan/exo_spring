package be.ros.spring_panier_exo.mappers;

import org.springframework.stereotype.Component;

import be.ros.spring_panier_exo.models.dtos.CategoryDTO;
import be.ros.spring_panier_exo.models.entities.Category;
import be.ros.spring_panier_exo.models.forms.CategoryForm;

@Component
public class CategoryMapper implements BaseMapper<CategoryDTO, CategoryForm, Category> {

    @Override
    public CategoryDTO entityToDto(Category entity) {
        return CategoryDTO.builder()
                .categoryId(entity.getCategoryId())
                .label(entity.getLabel())
                .build();
    }

    @Override
    public Category dtoToEntity(CategoryDTO dto) {
        return Category.builder()
                .categoryId(dto.getCategoryId())
                .label(dto.getLabel())
                .build();
    }

    @Override
    public Category formToEntity(CategoryForm form) {
        return Category.builder()
                .label(form.getLabel())
                .build();
    }
    
}
