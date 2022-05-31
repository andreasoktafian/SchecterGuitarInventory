package com.andreas.SchecterGuitarInventory.repositories;

import com.andreas.SchecterGuitarInventory.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}