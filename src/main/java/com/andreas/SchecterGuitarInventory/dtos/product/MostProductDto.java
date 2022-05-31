package com.andreas.SchecterGuitarInventory.dtos.product;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Product;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class MostProductDto implements Serializable {
    private final String product;
    private final String stock;

    public static MostProductDto setData(Product product){
        return new MostProductDto(
                product.fullProductName(),
                product.getStock() + " Units"
        );
    }

    public static List<MostProductDto> toList(List<Product> products){

        if(products.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<MostProductDto> result = products.stream().map(MostProductDto::setData);
        return result.toList();
    }
}
