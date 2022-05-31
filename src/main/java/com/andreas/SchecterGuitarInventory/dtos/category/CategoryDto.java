package com.andreas.SchecterGuitarInventory.dtos.category;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Category;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class CategoryDto implements Serializable {
    private final Integer id;
    private final String category;

    public static CategoryDto setData(Category category){
        return new CategoryDto(
                category.getId(),
                category.getCategoryName()
        );
    }

    public static List<CategoryDto> toList(List<Category> categories){

        if(categories.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<CategoryDto> result = categories.stream().map(CategoryDto::setData);
        return result.toList();
    }
}
