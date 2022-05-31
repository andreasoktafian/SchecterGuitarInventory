package com.andreas.SchecterGuitarInventory.repositories;

import com.andreas.SchecterGuitarInventory.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}