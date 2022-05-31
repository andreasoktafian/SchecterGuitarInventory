package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class NewProductDto implements Serializable {
    private final Integer id;
    private final String product;
    private final String stock;

    public static NewProductDto setData(Product product){
        return new NewProductDto(
                product.getId(),
                product.getProductName(),
                product.getStock() + " Units"

        );
    }
}
