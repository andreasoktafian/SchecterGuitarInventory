package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductInsertDto implements Serializable {
    private final Integer id;
    private final String productName;
    private final Integer categoryID;
    private final Integer seriesID;
    private final String string;
    private final String color;
    private final String bodyWood;
    private final String neckPickUp;
    private final String bridgePickUp;
    private final String bridge;
    private final Integer stock;

    public Product convert(){
        return new Product(
                productName,
                categoryID,
                seriesID,
                string,
                color,
                bodyWood,
                neckPickUp,
                bridgePickUp,
                bridge,
                stock
        );
    }
}
