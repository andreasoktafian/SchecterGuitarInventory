package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.series.SeriesDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesUpdateDto;
import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Series;
import com.andreas.SchecterGuitarInventory.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImplementation implements SeriesService{

    @Autowired
    private SeriesRepository repository;

    @Override
    public List<SeriesDto> findAllSeries() {
        return SeriesDto.toList(repository.findAll());
    }

    @Override
    public SeriesDto insertSeries(SeriesInsertDto newSeries) {
        Series series = newSeries.convert();
        repository.save(series);
        return SeriesDto.setData(series);
    }

    @Override
    public SeriesDto delete(Integer seriesID) {
        Series series =  repository.findById(seriesID)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Series Tidak Ditemukan"));

        repository.deleteById(seriesID);
        return SeriesDto.setData(series);
    }

    @Override
    public SeriesDto updateSeries(Integer seriesID, SeriesUpdateDto updateSeries) {
        Series cekSeries = repository.findById(seriesID)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND ,"Series Tidak Ditemukan"));

        Series series = repository.getById(seriesID);

        series.setSeriesName(updateSeries.getSeriesName() == null ? series.getSeriesName() : updateSeries.getSeriesName());

        repository.save(series);

        return SeriesDto.setData(series);
    }
}
