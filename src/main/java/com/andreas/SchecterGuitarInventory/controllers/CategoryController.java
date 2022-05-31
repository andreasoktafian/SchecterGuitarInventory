package com.andreas.SchecterGuitarInventory.controllers;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.exception.RestResponse;
import com.andreas.SchecterGuitarInventory.services.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServiceImplementation categoryService;

    @GetMapping
    public ResponseEntity<RestResponse<List<CategoryDto>>> findAllCategory(){
        return new ResponseEntity<>(
                new RestResponse<>(categoryService.findAllCategory(),
                        categoryService.findAllCategory().size() + " Category Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestResponse<CategoryDto>> insertNewCategory(@RequestBody CategoryInsertDto newCategory){
        return new ResponseEntity<>(
                new RestResponse<>(categoryService.insertCategory(newCategory),
                        "Berhasil Menambahkan Category.",
                        "201"),
                HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<CategoryDto>> delete(@RequestParam Integer categoryID){
        return new ResponseEntity<>(
                new RestResponse<>(categoryService.delete(categoryID),
                        "Data Berhasil Dihapus.",
                        "200"),
                HttpStatus.OK );
    }

    @PutMapping
    public ResponseEntity<RestResponse<CategoryDto>> update(@RequestParam Integer categoryID, @RequestBody CategoryUpdateDto updateCategory){
        return new ResponseEntity<>(
                new RestResponse<>(categoryService.updateCategory(categoryID,updateCategory),
                        "Data Category Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

}
