package com.andreas.SchecterGuitarInventory.repositories;

import com.andreas.SchecterGuitarInventory.models.RejectedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RejectedProductRepository extends JpaRepository<RejectedProduct, Integer> {
}