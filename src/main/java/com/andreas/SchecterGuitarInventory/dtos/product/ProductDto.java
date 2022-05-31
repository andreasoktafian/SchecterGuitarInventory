package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ProductDto implements Serializable {
    private final Integer id;
    private final String product;
    private final String category;
    private final String series;
    private final String string;
    private final String color;
    private final String bodyWood;
    private final String neckPickUp;
    private final String bridgePickUp;
    private final String bridge;
    private final String stock;

    public static ProductDto setData(Product product){
        return new ProductDto(
                product.getId(),
                product.fullProductName(),
                product.getCategoryID().getCategoryName(),
                product.getSeriesID().getSeriesName(),
                product.getString(),
                product.getColor(),
                product.getBodyWood(),
                product.getNeckPickUp(),
                product.getBridgePickUp(),
                product.getBridge(),
                product.getStock() + " Units"

        );
    }

    public static List<ProductDto> toList(List<Product> products){

        if(products.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<ProductDto> result = products.stream().map(ProductDto::setData);
        return result.toList();
    }
}
