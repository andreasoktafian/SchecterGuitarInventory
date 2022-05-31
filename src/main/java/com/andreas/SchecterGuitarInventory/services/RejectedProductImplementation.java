package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductDto;
import com.andreas.SchecterGuitarInventory.dtos.rejectedProduct.RejectedProductInsertDto;
import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Category;
import com.andreas.SchecterGuitarInventory.models.Product;
import com.andreas.SchecterGuitarInventory.models.RejectedProduct;
import com.andreas.SchecterGuitarInventory.repositories.CategoryRepository;
import com.andreas.SchecterGuitarInventory.repositories.ProductRepository;
import com.andreas.SchecterGuitarInventory.repositories.RejectedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RejectedProductImplementation implements RejectedProductService{

    @Autowired
    private RejectedProductRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<RejectedProductDto> findAllRejectedProduct() {
        return RejectedProductDto.toList((repository.findAll()));
    }

    @Override
    public boolean insertRejectedProduct(RejectedProductInsertDto newRejectedProduct) {
        RejectedProduct rejectedProduct = newRejectedProduct.convert();
        repository.save(rejectedProduct);

        Product product = productRepository.findById(newRejectedProduct.getProductID())
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Product Tidak Ditemukan"));

        product.setStock(newRejectedProduct.getUnits() == null ? 0 : product.getStock() - newRejectedProduct.getUnits());
        productRepository.save(product);

        return true;
    }


}
