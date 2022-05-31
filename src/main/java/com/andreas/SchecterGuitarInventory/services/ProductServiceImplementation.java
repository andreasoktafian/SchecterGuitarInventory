package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.product.*;
import com.andreas.SchecterGuitarInventory.exception.CustomException;
import com.andreas.SchecterGuitarInventory.models.Product;
import com.andreas.SchecterGuitarInventory.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductDto> findAllProduct() {
        return ProductDto.toList(repository.findAll());
    }

    @Override
    public NewProductDto insertProduct(ProductInsertDto newProduct) {

        Product product = newProduct.convert();
        repository.save(product);
        return NewProductDto.setData(product);
    }

    @Override
    public NewProductDto delete(Integer productID) {
        Product product =  repository.findById(productID)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND,"Product Tidak Ditemukan"));

        repository.deleteById(productID);
        return NewProductDto.setData(product);
    }

    @Override
    public NewProductDto updateProduct(Integer productID, ProductUpdateDto updateProduct) {
        Product cekProduct = repository.findById(productID)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND ,"Product Tidak Ditemukan"));

        Product product = repository.getById(productID);

        product.setProductName(updateProduct.getProductName() == null ? product.getProductName() : updateProduct.getProductName());
        product.setCategoryID(updateProduct.getCategoryID() == null ? product.getCategoryID() : updateProduct.getCategoryID());
        product.setSeriesID(updateProduct.getSeriesID() == null ? product.getSeriesID() : updateProduct.getSeriesID());
        product.setString(updateProduct.getString() == null ? product.getString() : updateProduct.getString());
        product.setColor(updateProduct.getColor() == null ? product.getColor() : updateProduct.getColor());
        product.setBodyWood(updateProduct.getBodyWood() == null ? product.getBodyWood() : updateProduct.getBodyWood());
        product.setNeckPickUp(updateProduct.getNeckPickUp() == null ? product.getNeckPickUp() : updateProduct.getNeckPickUp());
        product.setBridgePickUp(updateProduct.getBridgePickUp() == null ? product.getBridgePickUp() : updateProduct.getBridgePickUp());
        product.setBridge(updateProduct.getBridge() == null ? product.getBridge() : updateProduct.getBridge());
        repository.save(product);

        return NewProductDto.setData(product);
    }

    @Override
    public NewProductDto stockIn(Integer productID, StockInDto stock) {
        Product cekProduct = repository.findById(productID)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND ,"Product Tidak Ditemukan"));

        Product product = repository.getById(productID);

        product.setStock(stock.getUnits() == null ? 0 : product.getStock() + stock.getUnits());

        repository.save(product);

        return NewProductDto.setData(product);
    }

    @Override
    public NewProductDto stockOut(Integer productID, StockInDto stock) {
        Product cekProduct = repository.findById(productID)
                .orElseThrow(()-> new CustomException(HttpStatus.NOT_FOUND ,"Product Tidak Ditemukan"));

        Product product = repository.getById(productID);

        product.setStock(stock.getUnits() == null ? 0 : product.getStock() - stock.getUnits());

        repository.save(product);

        return NewProductDto.setData(product);
    }

    @Override
    public List<ProductByCategoryDto> productByCategory(Integer categoryID){
        return ProductByCategoryDto.toList(repository.productByCategory(categoryID));
    }

    @Override
    public List<ProductBySeriesDto> productBySeries(Integer seriesID) {
        return ProductBySeriesDto.toList((repository.productBySeries(seriesID)));
    }

    @Override
    public List<MostProductDto> mostProduct() {
        return MostProductDto.toList(repository.mostProduct());
    }


}
