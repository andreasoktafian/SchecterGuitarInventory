package com.andreas.SchecterGuitarInventory.services;

import com.andreas.SchecterGuitarInventory.dtos.product.*;

import java.util.List;

public interface ProductService {
    public List<ProductDto> findAllProduct();
    public NewProductDto insertProduct(ProductInsertDto newProduct);
    public NewProductDto delete(Integer productID);
    public NewProductDto updateProduct(Integer productID, ProductUpdateDto updateProduct);
    public NewProductDto stockIn(Integer productID, StockInDto stock);
    public NewProductDto stockOut(Integer productID, StockInDto stock);
    public List<ProductByCategoryDto> productByCategory(Integer categoryID);
    public List<ProductBySeriesDto> productBySeries(Integer categoryID);
    public List<MostProductDto> mostProduct();
}
