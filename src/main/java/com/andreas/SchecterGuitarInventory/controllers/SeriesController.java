package com.andreas.SchecterGuitarInventory.controllers;

import com.andreas.SchecterGuitarInventory.dtos.category.CategoryDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.category.CategoryUpdateDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesInsertDto;
import com.andreas.SchecterGuitarInventory.dtos.series.SeriesUpdateDto;
import com.andreas.SchecterGuitarInventory.exception.RestResponse;
import com.andreas.SchecterGuitarInventory.services.CategoryService;
import com.andreas.SchecterGuitarInventory.services.SeriesServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("series")
public class SeriesController {

    @Autowired
    private SeriesServiceImplementation service;

    @GetMapping
    public ResponseEntity<RestResponse<List<SeriesDto>>> findAllSeries(){
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllSeries(),
                        service.findAllSeries().size() + " Series Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestResponse<SeriesDto>> insertNewSeries(@RequestBody SeriesInsertDto newSeries){
        return new ResponseEntity<>(
                new RestResponse<>(service.insertSeries(newSeries),
                        "Berhasil Menambahkan Series.",
                        "201"),
                HttpStatus.CREATED);
    }

    @DeleteMapping("{seriesID}")
    public ResponseEntity<RestResponse<SeriesDto>> delete(@PathVariable Integer seriesID){
        return new ResponseEntity<>(
                new RestResponse<>(service.delete(seriesID),
                        "Data Berhasil Dihapus.",
                        "200"),
                HttpStatus.OK );
    }

    @PutMapping("{seriesID}")
    public ResponseEntity<RestResponse<SeriesDto>> update(@PathVariable Integer seriesID, @RequestBody SeriesUpdateDto updateSeries){
        return new ResponseEntity<>(
                new RestResponse<>(service.updateSeries(seriesID,updateSeries),
                        "Data Series Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

}
