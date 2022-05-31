package com.andreas.SchecterGuitarInventory.dtos.rejectedProduct;

import com.andreas.SchecterGuitarInventory.models.Product;
import com.andreas.SchecterGuitarInventory.models.RejectedProduct;
import lombok.Data;

import java.io.Serializable;

@Data
public class RejectedProductInsertDto implements Serializable {
    private final Integer id;
    private final Integer productID;
    private final Integer units;

    public RejectedProduct convert(){
        return new RejectedProduct(
                productID,
                units
        );
    }
}
