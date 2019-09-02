# Product-Catalog-API
A simple product-category API

# Technology stack

```bash
Java 8
Maven
RESTful API
SpringBoot Framework
Hibernate
JPA
Json
H2-in memory Database
Junit4, Mockito and PowerMockito for Unit Tetsing
```

## Building And Running

Using maven for building the application

```bash
mvn clean install 
```
Using maven to package the jar

```bash
mvn package
```
Standalone executable jar is placed under target ProductCatalog-0.0.1-SNAPSHOT.jar. So you can run this jar:

```bash
java -jar .\target\ProductCatalog-0.0.1-SNAPSHOT.jar
```

## Available RESTful APIs

```python
Product APIs:

Post- Add Product
http://localhost:8080/v1/products

Get- Get all Products
http://localhost:8080/v1/products

Get- Get Product by Id
http://localhost:8080/v1/products/{productId}

Put- Update Product by Id
http://localhost:8080/v1/products/{productId}

Delete- Delete Product by Id
http://localhost:8080/v1/products/{productId}

Get- List of all products that belong to particular categoryId
http://localhost:8080/v1/products/categories/1

Category APIs:

Post- Add Category
http://localhost:8080/v1/categories

Get- Get all categories
http://localhost:8080/v1/categoriesategories

Get- Get Category by Id
http://localhost:8080/v1/categories/{categoryId}

Put- Update Category by Id
http://localhost:8080/v1/categories/{categoryId}

Delete- Delete Category by Id
http://localhost:8080/v1/categories{categoryId}
```

## Http Status
```python
200 OK: OK - The request has succeeded
201 OK: CREATED - New resource has been created
204 OK: NO_CONTENT - The resource has been deleted successfully
400 Bad Request: BD_REQUEST - The request was invalid or cannot be served
404 Not Found: NOT_FOUND - There is no resource behind the URL
500 Internal Server Error: The server encountered an unexpected condition
```
## Note
Kindly please add categories before adding products
