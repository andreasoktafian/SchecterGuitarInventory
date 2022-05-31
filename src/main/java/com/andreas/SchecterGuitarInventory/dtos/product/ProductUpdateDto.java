package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.models.Category;
import com.andreas.SchecterGuitarInventory.models.Series;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductUpdateDto implements Serializable {

    private final Integer id;
    private final String productName;
    private final Category categoryID;
    private final Series seriesID;
    private final String string;
    private final String color;
    private final String bodyWood;
    private final String neckPickUp;
    private final String bridgePickUp;
    private final String bridge;
}
