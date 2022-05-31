package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesUpdateDto;

import java.util.List;

public interface SeriesService {
    public List<SeriesDto> findAllSeries();
    public SeriesDto insertSeries(SeriesInsertDto newSeries);
    public SeriesDto delete(Integer seriesID);
    public SeriesDto updateSeries(Integer seriesID, SeriesUpdateDto updateSeries);
}
