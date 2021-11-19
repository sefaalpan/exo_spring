package be.ros.spring_panier_exo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import be.ros.spring_panier_exo.mappers.CategoryMapper;
import be.ros.spring_panier_exo.models.dtos.CategoryDTO;
import be.ros.spring_panier_exo.models.entities.Category;
import be.ros.spring_panier_exo.models.forms.CategoryForm;
import be.ros.spring_panier_exo.repositories.CategoryRepository;
import be.ros.spring_panier_exo.services.BaseService;

@Service
public class CategoryServiceImpl implements BaseService<CategoryDTO, CategoryForm, Long> {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAll() {
        return this.categoryRepository.findAll().stream().map(this.categoryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getOneById(Long id) {
        return this.categoryMapper.entityToDto(this.categoryRepository.findById(id).orElse(null));
    }

    @Override
    public CategoryDTO save(CategoryForm tform) {
        return this.categoryMapper.entityToDto(this.categoryRepository.save(this.categoryMapper.formToEntity(tform)));
    }

    @Override
    public CategoryDTO update(CategoryForm tform, Long id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setLabel(tform.getLabel());
            this.categoryRepository.save(category);
        }
        return this.categoryMapper.entityToDto(category);
    }

    @Override
    public Long delete(Long id) {
        this.categoryRepository.deleteById(id);
        return id;
    }

}
