package com.ahsan.service;

import com.ahsan.entity.Product;
import com.ahsan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product)
    {
        return repository.save(product);
    }


    public List<Product> getProducts()
    {
        return repository.findAll();
    }


    public Product getProductById(int id)
    {
        return repository.findById(id).get();
    }


    public Product getProductByName(String name)
    {
        return repository.findByName(name);
    }


    public List<Product> getProductsByType(String productType)
    {
        return repository.findByProductType(productType);
    }

    public List<Product> getProductByPriceAndType(double price,String productType)
    {
        return repository.findByPriceAndProductType(price,productType);
    }


    public List<Product> getProductByPrice(double price)
    {
        return repository.getProductByPrice(price);
    }


    public Product updateProduct(int pid, Product product)
    {
        //--- step-1 : First Get Product from DB By Id :
        Product existingProduct = repository.findById(pid).get();


        //--- step-2 : Update the product with new values which we get

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());

        //--- step-3 : Now save the updated product
        return repository.save(existingProduct);

    }


    public Long deleteProduct(int pid)
    {
        System.out.println("Number of Records before deletion : " + repository.count());

        repository.deleteById(pid);

        System.out.print("Number of Records after deletion : " );
        return repository.count();
    }
}
