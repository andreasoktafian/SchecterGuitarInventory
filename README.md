# SchecterGuitarInventory

Project ini bertema tentang inventory sederhana sebuah gudang gitar dan bass dengan merk Schecter. Flow project ini sangat sederhana, yaitu CRUD Category, CRUD Series, CRUD PRODUCT, serta dapat menambah ataupun mengurangi unit stock. Terdapat juga fitur untuk memasukan jumlah barang yang rusak (Reject), sehingga akan mengurangi jumlah stock di produk  yang dituju.
Database SQL yang digunakan sudah disertakan dalam project ini dengan nama SchecterGuitar.
Untuk testing, saya menggunakan Aplikasi POSTMAN dengan URL, Method , Parameter, dan Body sebagai berikut :

1.	Find All Category
URL		: http://localhost:8080/category
Method	: GET
Parameter	: -
Body		: -

2.	Insert Category
URL		: http://localhost:8080/category
Method	: POST
Parameter	: -
Body		: 	{
    				"categoryName" : "Coba"
}

3.	Update Category
URL		: http://localhost:8080/category?categoryID=1
Method	: PUT
Parameter	: categoryID
Body		: 	{
    				"categoryName" : "Coba coba"
}

4.	Delete Category
URL		: http://localhost:8080/category?categoryID=1
Method	: DELETE
Parameter	: categoryID
Body		: -

5.	Find All Series
URL		: http://localhost:8080/series
Method	: GET
Parameter	: -
Body		: -

6.	Insert Series
URL		: http://localhost:8080/series
Method	: POST
Parameter	: -
Body		: 	{
    				"seriesName" : "Coba"
}

7.	Update Series
URL		: http://localhost:8080/series?seriesID=1
Method	: PUT
Parameter	: seriesID
Body		: 	{
    				"seriesName" : "Coba coba"
}

8.	Delete Category
URL		: http://localhost:8080/ series? series ID=1
Method	: DELETE
Parameter	: seriesID
Body		: -

9.	Find All Products
URL		: http://localhost:8080/product
Method	: GET
Parameter	: -
Body		: -

10.	Insert Product
URL		: http://localhost:8080/product
Method	: POST
Parameter	: -
Body		: 	{
    				"productName" : "Omen",
   				 "categoryID" : 1,
  				 "seriesID" : 1,
    				 "string" : "4",
   			    "color" : "Black Cherry",
            "bodyWood" : "Mahogany",
            "neckPickUp" : "EMG 81",
            "bridgePickUp" : "EMG 82",
            "bridge" : "Fix Bridge",
             "stock" : 5
}

11.	Update Product
URL		: http://localhost:8080/product?productID=1
Method	: PUT
Parameter	: productID
Body		: 	{
    				"productName" : "Omen",
   				 "categoryID" : 2,
  				 "seriesID" : 1,
    				 "string" : "4",
   			    "color" : "Blue Shapire",
            "bodyWood" : "Mahogany",
            "neckPickUp" : "EMG 81",
            "bridgePickUp" : "EMG 82",
            "bridge" : "Fix Bridge",
             "stock" : 5
}

12.	Delete Product
URL		: http://localhost:8080/product?productID=1
Method	: DELETE
Parameter	: productID
Body		: -

13.	Stock In
URL		: http://localhost:8080/product/stock-in?productID=1
Method	: PUT
Parameter	: productID
Body		:   {
               "units" : 5
            }

14.	Stock Out
URL		: http://localhost:8080/product/stock-in?productID=1
Method	: PUT
Parameter	: productID
Body		: {
               "units" : 5
            }

15.	Product By Category
URL		: http://localhost:8080/product/product-by-category?categoryID=1
Method	: GET
Parameter	: categoryID
Body		: -

16.	Product By Series
URL		: http://localhost:8080/product/product-by-series?seriesID=1
Method	: GET
Parameter	: seriesID
Body		: -


17.	Most Product
URL		: http://localhost:8080/product/most-product
Method	: GET
Parameter	: -
Body		: -

18.	Rejected Product FInd All
URL		: http://localhost:8080/reject
Method	: GET
Parameter	: -
Body		: -

19.	Rejected Product Insert
URL		: http://localhost:8080/reject
Method	: POST
Parameter	: -
Body		: {
               "productID" : 1
               "units" : 2
            }
