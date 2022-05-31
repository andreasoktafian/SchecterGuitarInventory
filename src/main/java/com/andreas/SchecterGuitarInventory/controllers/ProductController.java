package com.andreas.SchecterGuitarInventory.controllers;

import com.andreas.SchecterGuitarInventory.dtos.product.*;
import com.andreas.SchecterGuitarInventory.exception.RestResponse;
import com.andreas.SchecterGuitarInventory.services.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServiceImplementation service;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDto>>> findAllProduct(){
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllProduct(),
                        service.findAllProduct().size() + " Product Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestResponse<NewProductDto>> insertNewProduct(@RequestBody ProductInsertDto newProduct){
        return new ResponseEntity<>(
                new RestResponse<>(service.insertProduct(newProduct),
                        "Berhasil Menambahkan Product.",
                        "201"),
                HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<NewProductDto>> delete(@RequestParam Integer productID){
        return new ResponseEntity<>(
                new RestResponse<>(service.delete(productID),
                        "Data Berhasil Dihapus.",
                        "200"),
                HttpStatus.OK );
    }

    @PutMapping
    public ResponseEntity<RestResponse<NewProductDto>> update(@RequestParam Integer productID, @RequestBody ProductUpdateDto updateProduct){
        return new ResponseEntity<>(
                new RestResponse<>(service.updateProduct(productID,updateProduct),
                        "Data Product Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

    @PutMapping("stock-in")
    public ResponseEntity<RestResponse<NewProductDto>> stockIn(@RequestParam Integer productID, @RequestBody StockInDto stock){
        return new ResponseEntity<>(
                new RestResponse<>(service.stockIn(productID,stock),
                        "Data Stock Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

    @PutMapping("stock-out")
    public ResponseEntity<RestResponse<NewProductDto>> stockOut(@RequestParam Integer productID, @RequestBody StockInDto stock){
        return new ResponseEntity<>(
                new RestResponse<>(service.stockOut(productID,stock),
                        "Data Stock Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

    @GetMapping("product-by-category")
    public ResponseEntity<RestResponse<List<ProductByCategoryDto>>> productByCategory(@RequestParam Integer categoryID){
        return new ResponseEntity<>(
                new RestResponse<>(service.productByCategory(categoryID),
                        service.productByCategory(categoryID).size() + " Product Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @GetMapping("product-by-series")
    public ResponseEntity<RestResponse<List<ProductBySeriesDto>>> productBySeries(@RequestParam Integer seriesID){
        return new ResponseEntity<>(
                new RestResponse<>(service.productBySeries(seriesID),
                        service.productBySeries(seriesID).size() + " Product Ditemukan",
                "200"),
                HttpStatus.OK);
    }

    @GetMapping("most-product")
    public ResponseEntity<RestResponse<List<MostProductDto>>> mostProduct(){
        return new ResponseEntity<>(
                new RestResponse<>(service.mostProduct(),
                        service.mostProduct().size() + " Product Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

}
