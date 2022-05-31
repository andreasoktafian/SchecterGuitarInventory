package com.andreas.SchecterGuitarInventory.dtos.rejectedProduct;

import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.RejectedProduct;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

@Data
public class RejectedProductDto implements Serializable {
    private final Integer id;
    private final String product;
    private final String units;

    public static RejectedProductDto setData(RejectedProduct rejectedProduct){
        return new RejectedProductDto(
                rejectedProduct.getId(),
                rejectedProduct.getProductID().fullProductName(),
                rejectedProduct.getUnits() + " Units"

        );
    }

    public static List<RejectedProductDto> toList(List<RejectedProduct> rejectedProducts){

        if(rejectedProducts.size() == 0){
            throw new CustomException(HttpStatus.NOT_FOUND,"Tidak Ada Data Yang Sesuai.");
        }

        Stream<RejectedProductDto> result = rejectedProducts.stream().map(RejectedProductDto::setData);
        return result.toList();
    }
}
