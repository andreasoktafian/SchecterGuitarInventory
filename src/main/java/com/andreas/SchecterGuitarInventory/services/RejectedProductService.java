package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductDto;
import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductInsertDto;

import java.util.List;

public interface RejectedProductService {
    List<RejectedProductDto> findAllRejectedProduct();
    boolean insertRejectedProduct(RejectedProductInsertDto newRejectedProduct);
}
