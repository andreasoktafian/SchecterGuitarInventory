package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> findAllCategory();
    public CategoryDto insertCategory(CategoryInsertDto newCategory);
    public CategoryDto delete(Integer categoryID);
    public CategoryDto updateCategory(Integer categoryID, CategoryUpdateDto updateCategory);
}
