package com.ahsan.controller;

import com.ahsan.entity.Product;
import com.ahsan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
