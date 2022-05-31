package com.andreas.SchecterGuitarInventory.dtos.category;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryUpdateDto implements Serializable {

    private final Integer id;
    private final String categoryName;
}
