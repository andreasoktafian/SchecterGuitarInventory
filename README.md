# SchecterGuitarInventory

Project ini bertema tentang inventory sederhana sebuah gudang gitar dan bass dengan merk Schecter. Flow project ini sangat sederhana, yaitu CRUD Category, CRUD Series, CRUD PRODUCT, serta dapat menambah ataupun mengurangi unit stock. Terdapat juga fitur untuk memasukan jumlah barang yang rusak (Reject), sehingga akan mengurangi jumlah stock di produk  yang dituju.
Database SQL yang digunakan sudah disertakan dalam project ini dengan nama SchecterGuitar.
Untuk testing, saya menggunakan Aplikasi POSTMAN dengan URL, Method , Parameter, dan Body sebagai berikut :


# Schecter Guitar Inventory



<!--- If we have only one group/collection, then no need for the "ungrouped" heading -->


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| base | http://localhost:8080 | string |



## Endpoints

* [Category](#category)
    1. [Category Find All](#1-category-find-all)
    1. [Category Insert](#2-category-insert)
    1. [Category Update](#3-category-update)
    1. [Category Delete](#4-category-delete)
* [Series](#series)
    1. [Series Find All](#1-series-find-all)
    1. [Series Insert](#2-series-insert)
    1. [Series Update](#3-series-update)
    1. [Series Delete](#4-series-delete)
* [Rejected Product](#rejected-product)
    1. [Rejected Product Find All](#1-rejected-product-find-all)
    1. [Rejected Product Insert](#2-rejected-product-insert)
* [Product](#product)
    1. [Product FInd All](#1-product-find-all)
    1. [Product Insert](#2-product-insert)
    1. [Product Update](#3-product-update)
    1. [Product Delete](#4-product-delete)
    1. [Stock In](#5-stock-in)
    1. [Stock Out](#6-stock-out)
    1. [Product By Category ID](#7-product-by-category-id)
    1. [Product By Series](#8-product-by-series)
    1. [Most Product](#9-most-product)

--------



## Category



### 1. Category Find All



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/category
```



### 2. Category Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/category
```



***Body:***

```js        
{
    "categoryName" : "Coba"
}
```



### 3. Category Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/category
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| categoryID | 10 |  |



***Body:***

```js        
{
    "categoryName" : "Coba coba"
}
```



### 4. Category Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/category
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| categoryID | 10 |  |



## Series



### 1. Series Find All



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/series
```



### 2. Series Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/series
```



***Body:***

```js        
{
    "seriesName" : "Coba"
}
```



### 3. Series Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/series/8
```



***Body:***

```js        
{
    "seriesName" : "Coba lagi"
}
```



### 4. Series Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/series/8
```



## Rejected Product



### 1. Rejected Product Find All



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/reject
```



### 2. Rejected Product Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/reject
```



***Body:***

```js        
{
    "productID" : 1,
    "units" : 2
}
```



## Product



### 1. Product FInd All



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product
```



### 2. Product Insert



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: http://localhost:8080/product
```



***Body:***

```js        
{
    "productName" : "Coba",
    "categoryID" : 2,
    "seriesID" : 1,
    "string" : "4",
    "color" : "Black Cherry",
    "bodyWood" : "Mahogany",
    "neckPickUp" : "EMG 81",
    "bridgePickUp" : "EMG 82",
    "bridge" : "Fix Bridge",
    "stock" : 5
}
```



### 3. Product Update



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/product
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| productID | 9 |  |



***Body:***

```js        
{
    "productName" : "Coba lagi",
    "categoryID" : 1,
    "seriesID" : 1,
    "string" : "6",
    "color" : "Black Cherry",
    "bodyWood" : "Mahogany",
    "neckPickUp" : "Schecter Diamon Series Neck",
    "bridgePickUp" : "Schecter Diamon Series Bridge",
    "bridge" : "Floyd Rose Special"
}
```



### 4. Product Delete



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: http://localhost:8080/product
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| productID | 9 |  |



### 5. Stock In



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/product/stock-in
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| productID | 4 |  |



***Body:***

```js        
{
    "units" : 5
}
```



### 6. Stock Out



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: http://localhost:8080/product/stock-out
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| productID | 4 |  |



***Body:***

```js        
{
    "units" : 1
}
```



### 7. Product By Category ID



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product/product-by-category
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| categoryID | 1 |  |



### 8. Product By Series



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product/product-by-series
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| seriesID | 1 |  |



### 9. Most Product



***Endpoint:***

```bash
Method: GET
Type: 
URL: http://localhost:8080/product/most-product
```



---
[Back to top](#schecter-guitar-inventory)


