package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Category;
import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ProductByCategoryDto implements Serializable {
    private final String product;
    private final String category;
    private final String stock;

    public static ProductByCategoryDto setData(Product product){
        return new ProductByCategoryDto(
                product.fullProductName(),
                product.getCategoryID().getCategoryName(),
                product.getStock() + " Units"
        );
    }

    public static List<ProductByCategoryDto> toList(List<Product> products){

        if(products.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<ProductByCategoryDto> result = products.stream().map(ProductByCategoryDto::setData);
        return result.toList();
    }
}
