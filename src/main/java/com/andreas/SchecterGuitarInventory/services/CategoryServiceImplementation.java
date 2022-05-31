package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Category;
import com.andreas.SchecterGuitarInventory.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAllCategory() {
        return CategoryDto.toList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto insertCategory(CategoryInsertDto newCategory) {

        Category category = newCategory.convert();
        categoryRepository.save(category);
        return CategoryDto.setData(category);
    }

    @Override
    public CategoryDto delete(Integer categoryID) {
        Category category =  categoryRepository.findById(categoryID)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Category Tidak Ditemukan"));

        categoryRepository.deleteById(categoryID);
        return CategoryDto.setData(category);
    }

    @Override
    public CategoryDto updateCategory(Integer categoryID, CategoryUpdateDto updateCategory) {
        Category cekCategory = categoryRepository.findById(categoryID)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND ,"Category Tidak Ditemukan"));

        Category category = categoryRepository.getById(categoryID);

        category.setCategoryName(updateCategory.getCategoryName() == null ? category.getCategoryName() : updateCategory.getCategoryName());

        categoryRepository.save(category);

        return CategoryDto.setData(category);
    }


}
