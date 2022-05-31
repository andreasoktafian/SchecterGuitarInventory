package com.andreas.SchecterGuitarInventory.dtos.category;

import com.andreas.SchecterGuitarInventory.models.Category;
import com.andreas.SchecterGuitarInventory.repositories.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class CategoryInsertDto implements Serializable {
    private final Integer id;
    private final String categoryName;

    public Category convert(){
        return new Category(categoryName);
    }
}
