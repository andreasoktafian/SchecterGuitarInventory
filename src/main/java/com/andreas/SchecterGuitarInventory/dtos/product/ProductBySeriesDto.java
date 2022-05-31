package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class ProductBySeriesDto implements Serializable {
    private final String product;
    private final String series;
    private final String stock;

    public static ProductBySeriesDto setData(Product product){
        return new ProductBySeriesDto(
                product.fullProductName(),
                product.getSeriesID().getSeriesName(),
                product.getStock() + " Units"
        );
    }

    public static List<ProductBySeriesDto> toList(List<Product> products){

        if(products.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<ProductBySeriesDto> result = products.stream().map(ProductBySeriesDto::setData);
        return result.toList();
    }
}
