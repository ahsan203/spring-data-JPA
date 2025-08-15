package com.ahsan.controller;

import com.ahsan.entity.Product;
import com.ahsan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    private ProductService service;


    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        return service.saveProduct(product);
    }


    @GetMapping
    public List<Product> getProducts()
    {
        return service.getProducts();
    }


    @GetMapping("/{id}")
    public Product getProductBYId(@PathVariable int id)
    {
        return service.getProductById(id);
    }


    @GetMapping("/productName/{name}")
    public Product getProductByName(@PathVariable String name)
    {
        return service.getProductByName(name);
    }


    @GetMapping("/productType/{type}")
    public List<Product> getProductsByType(String type)
    {
        return service.getProductsByType(type);
    }

    @GetMapping("/productPrice/{price}/productType/{type}")
    public List<Product> getProductByPriceAndType(@PathVariable double price,@PathVariable String type)
    {
        return service.getProductByPriceAndType(price,type);
    }


    @GetMapping("/productPrice/{price}")
    public List<Product> getProductByPrice(@PathVariable double price)
    {
        return service.getProductByPrice(price);
    }


    @PutMapping("/update/{pid}")
    public Product updateProduct(@PathVariable int pid, @RequestBody Product product)
    {

        return service.updateProduct(pid,product);
    }


    @DeleteMapping("/deleteProduct/{pid}")
    public Long deleteProduct(@PathVariable int pid)
    {

        return service.deleteProduct(pid);
    }


    //---------------------- Using SQL operators : --------------------------------

    @PostMapping("/product-based-prices")
    public List<Product> getproductByMultiplePriceValues(@RequestBody List<Double> prices)
    {
        return service.getproductByMultiplePriceValues(prices);
    }

    //------- using BETWEEN of SQL --- SELECT * FROM springjpa.product_table where price between 300 AND 1000;
    @GetMapping("/getProducts-ByRange/{value1}/{value2}")
    public List<Product> getProductsByPricesBetween(@PathVariable double value1,@PathVariable double value2)
    {
        return service.getProductsByPricesBetween(value1,value2);
    }

    //---- using LessThan and GreaterThan of SQL:
    @GetMapping("/product-filtering-higher-prices/{price}")
    public List<Product> getProductsWithHigherPrices(@PathVariable double price)
    {
        return service.getProductsWithHigherPrices(price);
    }
    @GetMapping("/product-filtering-lower-prices/{price}")
    public List<Product> getProductsWithLowerPrices(@PathVariable double price)
    {
        return service.getProductsWithLowerPrices(price);
    }

    @GetMapping("/product-filtering-by-name/{likeString}")
    public List<Product> getProductsWithLike(@PathVariable String likeString)
    {
        return service.getProductsWithLike(likeString);
    }



    //--------- Sorting & Pagination in JPA : ------------

    @GetMapping("/product-sorting/{fieldName}")
    public List<Product> getProductsWithSorting(@PathVariable String fieldName)
    {
        return service.getProductsWithSorting(fieldName);
    }

    @GetMapping("/page-limit/{offset}/{limit}")
    public Page<Product> getProductsWithPageResponse(@PathVariable int offset, @PathVariable int limit)
    {
        return service.getProductsWithPageResponse(offset,limit);
    }

    @GetMapping("/product-sorting-and-limit/{fieldName}/{offset}/{limit}")
    public Page<Product> getProductsWithSortingAndPagination(@PathVariable String fieldName, @PathVariable int offset, @PathVariable int limit)
    {
        return service.getProductsWithSortingAndPagination(fieldName,offset,limit);
    }
}
