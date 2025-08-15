package com.ahsan.service;

import com.ahsan.entity.Product;
import com.ahsan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    //----- using IN of SQL------ SELECT * FROM product_table WHERE price IN (300,500,5500);
    public List<Product> getproductByMultiplePriceValues(List<Double> prices)
    {
        return repository.findByPriceIn(prices);
    }

    //------- using BETWEEN of SQL --- SELECT * FROM springjpa.product_table where price between 300 AND 1000;
    public List<Product> getProductsByPricesBetween(double value1, double value2)
    {
        return repository.findByPriceBetween(value1,value2);
    }

    //---- using LessThan and GreaterThan of SQL:
    public List<Product> getProductsWithHigherPrices(double price)
    {
        return repository.findByPriceGreaterThan(price);
    }

    public List<Product> getProductsWithLowerPrices(double price)
    {
        return repository.findByPriceLessThan(price);
    }

    public List<Product> getProductsWithLike(String likeString)
    {
        return repository.findByNameIgnoreCaseContaining(likeString);
    }


    //------- Sorting & Pagination : Similarly in SQL we have = ORDER BY & Limit Offset -------------------

            //------- Sorting in JPA we use by overloaded findAll(Sort sort) method :-------------
    public List<Product> getProductsWithSorting(String fieldName)
    {
        return repository.findAll(Sort.by(Sort.Direction.ASC,fieldName));
    }

            //-------- Pagination in JPA : we use again findAll(Pageable pageable) method : ---------------
    public Page<Product> getProductsWithPageResponse(int offset, int limit)
    {
        return repository.findAll(PageRequest.of(offset,limit));

    }



    //---------- Using Sorting and Pagination together
    public Page<Product> getProductsWithSortingAndPagination(String fieldName, int offset, int limit)
    {
        List<Product> sortedProducts = repository.findAll(Sort.by(Sort.Direction.ASC,fieldName));

        return repository.findAll(PageRequest.of(offset,limit));
    }
}
