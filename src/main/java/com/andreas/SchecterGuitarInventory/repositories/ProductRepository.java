package com.andreas.SchecterGuitarInventory.repositories;

import com.andreas.SchecterGuitarInventory.dtos.product.ProductByCategoryDto;
import com.andreas.SchecterGuitarInventory.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = """
            SELECT *
            FROM Product
            WHERE categoryID = :categoryID
            """, nativeQuery = true)
    List<Product> productByCategory(Integer categoryID);

    @Query(value = """
            SELECT *
            FROM Product
            WHERE seriesID = :seriesID
            """, nativeQuery = true)
    List<Product> productBySeries(Integer seriesID);

    @Query(value = """
            SELECT *
            FROM Product AS p
            ORDER BY p.stock DESC
            """, nativeQuery = true)
    List<Product> mostProduct();
}